.data
	msg1: .asciiz"\nDigite um numero: "
	msg2: .asciiz"\n"
.text
main:
	#Escreva msg1
	li $v0, 4
	la $a0, msg1
	syscall
	
	#Leia $t0
	li $v0, 5
	syscall
	add $t0, $v0, $zero

	#$t5 acumulador
	li $t5, 0
	
	
	enquanto:
		#$t2 <- $t0 * $t5
		mul $t2, $t0, $t5
		
		#$t5 <- $t5 + 1
		add $t5, $t5, 1
		
		li $v0, 1
		add $a0, $t2, $zero
		syscall
		
		li $v0, 4
		la $a0, msg2
		syscall
		
	ble $t5, 10, enquanto