.data
	msg1: .asciiz"\nDigite um numero A: "
	msg2: .asciiz"\nDigite um numero B:"
	msg3: .asciiz"\n1"
	msg4: .asciiz"\nNumero invalido"
.text
main:
	#Msg1
	li $v0, 4
	la $a0, msg1
	syscall
	
	#leitura
	li $v0, 5
	syscall
	add $t0, $v0, $zero #t0 onde esta armazenado
	
	#Msg2
	li $v0, 4
	la $a0, msg2
	syscall
	
	#leitura
	li $v0, 5
	syscall
	add $t1, $v0, $zero #t1 onde esta armazenado

	beq $t1, 0, se4
	
	#verificacao se A maior que 0
	bgt $t0, 0, se3
	#verificacao se B maior igual que 0
	se3:
	bge $t1, 0, se1
	j senao1
	
	se1:
	add $t3, $t0, 0 #t3 = t0 + 0
	sub $t1, $t1, 1 #t1 = t1 - 1 (para nao fazer um a mais)
	
	#enquanto
	enquanto:
	mul $t3, $t3, $t0 #t3 = t3 * t1
	sub $t1, $t1, 1 #t1 = t1 - 1 contador
	syscall
	
	bne $t1, 0 enquanto
	
	#escreva int
	li $v0, 1
	add $a0, $t3, 0
	syscall
	
	j fimse1
	
	#senao da verificacao
	senao1:
	li $v0, 4
	la $a0, msg4
	syscall
	j fimse1

	se4:
	li $v0, 4
	la $a0, msg3
	syscall
	j fimse1
	
	fimse1: