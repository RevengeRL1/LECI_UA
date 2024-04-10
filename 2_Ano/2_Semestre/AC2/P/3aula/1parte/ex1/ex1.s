.data
.equ    ADDR_BASE_HI,0xBF88
.equ    TRISB,0x6040
.equ    TRISE,0x6100
.equ    PORTB,0x6050
.equ    LATE,0x6120
.text
.globl main

main:   lui $t1,ADDR_BASE_HI
        lw  $t2,TRISB($t1)
        ori $t2,$t2,0x0001
        sw  $t2,TRISB($t1)

        lw  $t3,TRISE($t1)
        andi    $t3,$t3,0xFFFE
        sw  $t3,TRISE($t1)


while:  lw  $t4,PORTB($t1)
        sw  $t4,LATE($t1)
        j   while

        li  $v0,0
        jr  $ra