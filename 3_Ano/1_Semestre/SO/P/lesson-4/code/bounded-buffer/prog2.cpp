#include <stdio.h>
#include "thread.h"

static int sharedValue;


void *child(void *args){
    int n_2 = 0;
    while(n_2 < 10 || n_2 > 20){
        printf("Insert N2 value between 10 and 20: ");
        scanf("%d", &n_2);
    }

    printf("\n");
    printf("%d\n", sharedValue);
    while (sharedValue != n_2){
        sharedValue++;
        printf("%d\n", sharedValue);
    }

    return NULL;
}

int main(void){
    int n_1 = 0;
    while(n_1 < 1 || n_1 > 9){
        printf("Insert N1 value between 1 and 9: ");
        scanf("%d", &n_1);
    }
    sharedValue = n_1;

    pthread_t thr;

    thread_create(&thr, NULL, child, NULL);

    thread_join(thr, NULL);
    printf("\n");
    printf("%d\n", sharedValue);
    while(sharedValue != 1){
        sharedValue--;
        printf("%d\n", sharedValue);
    }

    return 0;
}