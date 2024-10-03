#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>

#include "delays.h"
#include "process.h"


int main()
{
    pid_t ret = pfork();

    if (ret == 0)
    {
        for(int i = 1; i <= 10; i++)
        {
            printf("%d\n", i);

        }
    }
    else
    {
        pwait(NULL);    // wait() aqui para só executar o for loop depois do filho terminar
                        // só incluir o wait() dentro do processo pai (ret > 0)
        for(int i = 11; i <= 20; i++)
        {
            printf("%d\n", i);
        }
    }
    return EXIT_SUCCESS;
}