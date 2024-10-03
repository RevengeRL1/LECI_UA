#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>

#include "delays.h"
#include "process.h"

int main(void)
{
  printf("Before the fork: PID = %d, PPID = %d\n", getpid(), getppid());

  pfork(); // equivalent to fork(), dealing internally with error situations
  
  printf("After the fork: PID = %d, PPID = %d\n",getpid(), getppid());
  bwRandomDelay(1000, 100000); // added to enhance the occurrence of different outputs
  printf("  Was I printed by the parent or by the child process? How can I know it?\n"); 
  
  return EXIT_SUCCESS;
}


/* Notas:
    - "Before the fork" so da print uma vez porque so existe 1 processo ativo (parent)

    - "After the fork" da print duas vezes porque criamos um fork, que cria um 
      processo child que executa ao mesmo tempo que o parent

    - O PPID do primeiro processo corresponde ao PID do processo que executou o programa
      por exemplo, a shell (para checkar PID da shell: echo $$)

    - O print final as vezes acontece depois do prompt da bash. Isso significa
    que quem printou essa mensagem foi o processo child, porque o processo parent
    ja terminou
*/
