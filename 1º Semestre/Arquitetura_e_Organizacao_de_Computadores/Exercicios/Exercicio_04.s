.data
	msg1: .asciiz"\nDigite um numero: "
	msg2: .asciiz"\nNumero invalido"
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
	
	beq $t0, 0, senao
	
	#verificacao se N maior que 0
	bgt $t0, 0, se
	j senao
	
	se:
	#enquanto
	enquanto:
	add $t1, $t1, 1 #t1 = t1 + 1 contador
	#escreva int
	li $v0, 1
	add $a0, $t1, 0
	syscall
	blt $t1, $t0 enquanto
	
	j fimse
	
	#senao da verificacao
	senao:
	li $v0, 4
	la $a0, 2
	syscall
	j fimse
	
	fimse: