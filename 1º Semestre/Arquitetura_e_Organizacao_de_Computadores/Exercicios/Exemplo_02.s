.data
	msg1: .asciiz"\nDigite um numero: "
	msg2: .asciiz"\nPar"
	msg3: .asciiz"\nImpar"
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
	
	#$t1 <- $t0 mod 2
	rem $t1, $t0, 2
	
	#Se $t1 == 0, GOTO(vai para) se:
	beq $t1, 0, se
	j senao
	
	se:
	li $v0, 4
	la $a0, msg2
	syscall
	j fimse
	
	senao:
	li $v0, 4
	la $a0, msg3
	syscall
	j fimse
	
	fimse:
	