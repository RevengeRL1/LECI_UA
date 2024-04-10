// 20.000.000 - 1 segundo
// 200.000 - x
// x = 1ms


.data
.equ READ_CORE_TIMER,11
.equ RESET_CORE_TIMER,12
.equ PUT_CHAR,3
.equ PRINT_INT,6
.text
.globl main

main:   li  $t0,0

while:  la  $v0,PUT_CHAR
        li  $a0,'\r'
        syscall

        la  $v0,PRINT_INT
        li  $a0,$t0
        li  $a1,0x0004000A
        syscall

        la  $v0,RESET_CORE_TIMER
        syscall

while2: la  $v0,READ_CORE_TIMER
        syscall
        blt $v0,200000,while2

        addi    $t0,$t0,1
        
        j   while
        jr  $ra