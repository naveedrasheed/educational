[ORG 0x100]
	
	mov ax,[Num1]     ;move the first numver in ax
	mov bx,[Num1 + 2]	  ;move the second number in bx
	mov ax,bx	  ;add first and second numbers	
	mov bx,[Num1 + 4]     ;move the third number in bx
	mov ax,bx	  ;move the third in bx
	mov [Num1 + 6], ax    
	
	mov ax,0x4c00
	int 0x21
;execution never comes at this line
	Num1: dw 5
	      dw 10
	      dw 15
	      dw 0



	