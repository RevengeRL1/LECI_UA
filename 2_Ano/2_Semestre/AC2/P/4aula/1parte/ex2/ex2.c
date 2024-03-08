#include <detpic32.h>


// NOTAS:   4.6Hz corresponde a um período de 0.217391s
//          Como o microcontrolador corre a uma freq. de 20000000Hz, calculamos o 
//          valor do delay com regra de três simples: 0.217391 * 20000000 = 4347826
int main(void){
    TRISE = TRISE & 0xFF87; // Queremos mudar os bits RE3-RE6 para outputs (0)
                            // e manter os outros inalterados
    int counter = 0;
    while(1){
        LATE = (LATE & 0xFF87) | counter << 3;  // Alinhar o contador com os bits 3-6
                                                // por isso, shiftamos 3 vezes para a esquerda
        resetCoreTimer();
        while(readCoreTimer() < 4347826 );
        counter = (counter + 1) % 10;
    }
    return 0;
}