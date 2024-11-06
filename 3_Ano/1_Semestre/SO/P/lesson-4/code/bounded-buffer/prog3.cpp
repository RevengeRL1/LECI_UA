#include <stdio.h>
#include "thread.h"


static int sharedValue;
static int flag = 0;
static pthread_mutex_t mutex_access;
static pthread_cond_t go;

void *child(void *args){
    int thread_id = *(int *)args;
    while(1){

        mutex_lock(&mutex_access);
        while(flag != thread_id){
            cond_wait(&go, &mutex_access);
        }

        if (sharedValue == 1){
            flag = 1 - flag;
            cond_broadcast(&go);
            mutex_unlock(&mutex_access);
            break;
        }
        sharedValue--;
        printf("Value: %d -- Thread ID: %d\n", sharedValue, thread_id);
        flag = 1 - flag;
        cond_broadcast(&go);
        mutex_unlock(&mutex_access);

    }
    return NULL;
}

int main(void){
    mutex_init(&mutex_access, NULL);
    cond_init(&go, NULL);

    int value = 0;
    while(value < 10 || value > 20){
        printf("Insert a value between 10 and 20: ");
        scanf("%d", &value);
    }
    sharedValue = value;

    pthread_t cthr[2];
    int id[2] = {0, 1};
    thread_create(&cthr[0], NULL, child, &id[0]);
    thread_create(&cthr[1], NULL, child, &id[1]);

    
    thread_join(cthr[0], NULL);
    thread_join(cthr[1], NULL);
    return 0;
}

