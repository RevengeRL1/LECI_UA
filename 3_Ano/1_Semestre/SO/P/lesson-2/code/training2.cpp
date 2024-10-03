#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>

#include "delays.h"
#include "process.h"

int main()
{
    for (int i = 1; i <= 40; i++)
    {
        printf("=");
    }
    printf("\n");

    pid_t ret = pfork();

    if (ret == 0)
    {
        pexecl("/usr/bin/ls", "/usr/bin/ls", "-l", NULL); // acrescentamos o argumento -l
    }
    else
    {
        pwait(NULL);
        for (int i = 1; i <= 40; i++)
        {
            printf("=");
        }
        printf("\n");
    }

    
}