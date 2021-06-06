.data
	msg0: .asciiz"O Programa coleta 10 numeros e mostra o maior e menor."
	msg1: .asciiz"\nDigite um numero: "
	msg2: .asciiz"\nValor incorreto! Deve ser maior que 0"
	msg3: .asciiz"\nO maior numero: "
	msg4: .asciiz"\nO menor numero: "
.text
main:
	li $v0, 4
	la $a0, msg0
	syscall
	
	li $v0, 4
	la $a0, msg1
	syscall
    
	li $v0, 5
	syscall
    blt $v0, 0, erro
	
	li $t5, 2
	add $t1, $v0, $zero
	add $t2, $v0, $zero
	
	beq $t1, $t2, laco
	j fim
	
	laco:
	li $v0, 4
	la $a0, msg1
	syscall
    
	li $v0, 5
	syscall
	add $t3, $v0, $zero
    
    
	blt $v0, 0, erro
	blt $t3, $t1, menor
	bgt $t3, $t2, maior
	add $t5, $t5, 1
	bgt $t5, 10, fim
	j laco
	
	menor:
	add $t1, $t3, $zero
	add $t5, $t5, 1
	bgt $t5, 10, fim
	j laco
	
	maior:
	add $t2, $t3, $zero
	add $t5, $t5, 1
	bgt $t5, 10, fim
	j laco
	
	fim:
	li $v0, 4
	la $a0, msg3
	syscall
    
	li $v0, 1
	add $a0, $t2, $zero
	syscall
	
	li $v0, 4
	la $a0, msg4
	syscall
    
	li $v0, 1
	add $a0, $t1, $zero
	syscall
	j final
	
	erro:
	li $v0, 4
	la $a0, msg2
	syscall
	
	final: