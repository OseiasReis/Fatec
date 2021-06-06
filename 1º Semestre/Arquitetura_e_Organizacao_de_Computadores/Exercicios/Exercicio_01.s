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
	
	#contador t5 vale 1
	li $t5, 1 
	
	#verificação se maior que 10
	bgt $t0, 10, se1
	#blt $t0, 15, se1
	j senao1
	
	se1:
	
	#enquanto e guardando resto em t3 de t0 % 2
	enquanto:
	rem $t3, $t5, 2
	
	#se t3 igual a 0
	beq $t3, 0, se
	j senao
	
	se:
	mul $t1, $t5, 2 #t1 = t5 * 2
	add $t5, $t5, 1 #t5 = t5 + 1 contador
	add $t6, $t6, $t1 #t6 = t6 + t1 resultado mais a mult
	syscall
	j fimse

	#senão
	senao:
	mul $t2, $t5, 3 #t1 = t5 * 3
	add $t5, $t5, 1 #t5 = t5 + 1 contador
	add $t6, $t6, $t2 #t6 = t6 + t1 resultado mais a mult
	syscall
	j fimse
	
	fimse:
	
	ble $t5, $t0 enquanto
	
	#escreva int
	li $v0, 1
	add $a0, $t6, 0
	syscall
	
	#escreva caracter
	li $v0, 4
	la $a0, msg2
	syscall
	
	j fimse1
	
	#senão da verificação
	senao1:
	li $v0, 4
	la $a0, msg3
	syscall
	j fimse1
	
	fimse1: