; a program to add three using registers
[org 0x100]
		mov ax,5	;load first number in ax
		mov bx, 10	;load second number in bx
		add ax,bx	;accumlate sum in ax
		mov bx,15	;load third number in bx
		add ax,bx	;accumulate sum in ax

		mov ax,0x4c00	;terminate program
		int 0x21 