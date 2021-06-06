.data
	msg1: .asciiz"\nDigite um numero: "
	msg2: .asciiz"\n"
	msg3: .asciiz"\nDigite outro numero"
.text
main:
	#Msg
	li $v0, 4
	la $a0, msg1
	syscall
	
	#leitura
	li $v0, 5
	syscall
	add $t0, $v0, $zero #t0 onde esta armazenado
	
	#verificação se maior
	bgt $t0, 12, se
	j senao
	
	se:
	
	#se $t0 igual 0, $t0=1
	beq $t0, 0, se1
	j senao1
	
	se1:
	li $t0, 1
	syscall
	senao1:
	
	#enquanto
	enquanto:
	
	add $t2, $t3, $t1 #n = x * r
	sub $t3, $t1, 1 #x = r - 1
	add $t1, $t1, $t2 #r = n
	syscall
	
	#escreva
	li $v0, 1
	add $a0, $t1, 0
	syscall
	
	blt $t1, $t0 enquanto
	
	j fimse
	
	#senão da verificação
	senao:
	li $v0, 4
	la $a0, msg3
	syscall
	j fimse
	
	fimse: