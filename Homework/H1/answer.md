###H1
=========

-This project uses gcc/clang to complier a simple C program to produce an assembly file.
-Observe the assembly code and add comments. 
-Compare output file in diffrent complier options.

The C program is for greatest common divisor.
=========

Source code:

```
#include <stdio.h>

int main(){
	int gcd(int a,int b);
	
	int a,b;
	scanf("%d %d",&a,&b);
	printf("%d",gcd(a,b));
;} 

int gcd(int a,int b){
	int c;
	while(a!=b){
		c = a > b? a-b : b - a;
		a=b;
		b=c;
	}
	return b;
}
```
---------------------------------------
with option of "-m64" using gcc:

```
	.file	"gcd.c"
	.section	.rodata		#read only data
.LC0:
	.string	"%d %d"			#location for scanf
.LC1:
	.string	"%d"			#location for printf
	.text
	.globl	main
	.type	main, @function
main:
.LFB0:
	.cfi_startproc				#start of one function
	pushq	%rbp				#save old frame pointer
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	movq	%rsp, %rbp			#new frame pointer
	.cfi_def_cfa_register 6
	subq	$16, %rsp		
	movq	%fs:40, %rax		#bias in print
	movq	%rax, -8(%rbp)		#?
	xorl	%eax, %eax
	leaq	-12(%rbp), %rdx		
	leaq	-16(%rbp), %rax
	movq	%rax, %rsi			#prepare the stack for the parameter to be receive
	leaq	.LC0(%rip), %rdi	#%rip+.LC0 is the address of the location where ".LC0" is
 	movl	$0, %eax
	call	__isoc99_scanf@PLT	#scanf
	movl	-12(%rbp), %edx
	movl	-16(%rbp), %eax
	movl	%edx, %esi
	movl	%eax, %edi			#move two input numbers as parameters
	call	gcd
	movl	%eax, %esi			#return value,saved in source index
	leaq	.LC1(%rip), %rdi	#the address of sentence to be printed,saved in dest index
	movl	$0, %eax
	call	printf@PLT			#printf
	movl	$0, %eax
	movq	-8(%rbp), %rcx
	xorq	%fs:40, %rcx		#%rcx=0
	je	.L3
	call	__stack_chk_fail@PLT	#cannary, check the stack overflow
.L3:
	leave
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc				#end of the function
.LFE0:
	.size	main, .-main
	.globl	gcd
	.type	gcd, @function
gcd:
.LFB1:
	.cfi_startproc				#start of the other function
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register 6
	movl	%edi, -20(%rbp)
	movl	%esi, -24(%rbp)		#save parameters on the stack
	jmp	.L5
.L8:
	movl	-20(%rbp), %eax
	cmpl	-24(%rbp), %eax
	jle	.L6
	movl	-20(%rbp), %eax
	subl	-24(%rbp), %eax
	jmp	.L7
.L6:
	movl	-24(%rbp), %eax
	subl	-20(%rbp), %eax		#L6/l7 compare which para is bigger and sub the bigger to the smaller
.L7:
	movl	%eax, -4(%rbp)
	movl	-24(%rbp), %eax
	movl	%eax, -20(%rbp)
	movl	-4(%rbp), %eax
	movl	%eax, -24(%rbp)		#use stack as intermediate to exchange b and c
.L5:
	movl	-20(%rbp), %eax
	cmpl	-24(%rbp), %eax
	jne	.L8			#compare two parameters
	movl	-24(%rbp), %eax
	popq	%rbp			#do-while structure
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc				$end of the other function
.LFE1:
	.size	gcd, .-gcd
	.ident	"GCC: (Ubuntu 6.2.0-5ubuntu12) 6.2.0 20161005"
	.section	.note.GNU-stack,"",@progbits
```
-------------------------------------------------------------
with option "-m32" using gcc:

```
	.file	"gcd.c"
	.section	.rodata
.LC0:
	.string	"%d %d"
.LC1:
	.string	"%d"
	.text
	.globl	main
	.type	main, @function
main:
.LFB0:
	.cfi_startproc
	leal	4(%esp), %ecx
	.cfi_def_cfa 1, 0
	andl	$-16, %esp    					#clear %esp lowest four bits
	pushl	-4(%ecx)						#it is beneficial to aligning
	pushl	%ebp							#save old frame pointer
	.cfi_escape 0x10,0x5,0x2,0x75,0			#"cfi_escape" Allows the user to add arbitrary bytes to the unwind 
	movl	%esp, %ebp						#info. One might use this to add OS-specific CFI opcodes, or generic CFI opcodes that GAS does not yet support. 
	pushl	%ebx
	pushl	%ecx
	.cfi_escape 0xf,0x3,0x75,0x78,0x6
	.cfi_escape 0x10,0x3,0x2,0x75,0x7c
	subl	$16, %esp
	call	__x86.get_pc_thunk.bx
	addl	$_GLOBAL_OFFSET_TABLE_, %ebx	#base address
	movl	%gs:20, %eax
	movl	%eax, -12(%ebp)					#save alias
	xorl	%eax, %eax
	subl	$4, %esp
	leal	-16(%ebp), %eax 				#prepare stack for input
	pushl	%eax
	leal	-20(%ebp), %eax
	pushl	%eax
	leal	.LC0@GOTOFF(%ebx), %eax         #?
	pushl	%eax 							#return address
	call	__isoc99_scanf@PLT				#scanf
	addl	$16, %esp 						
	movl	-16(%ebp), %edx
	movl	-20(%ebp), %eax 				
	subl	$8, %esp 						#researve space for called func
	pushl	%edx 							#move two parameters form stack to stack
	pushl	%eax
	call	gcd
	addl	$16, %esp 						#recover stack
	subl	$8, %esp 						#ditto, reserve space ; the two instructions should have been optimized to one instruction
	pushl	%eax
	leal	.LC1@GOTOFF(%ebx), %eax
	pushl	%eax
	call	printf@PLT
	addl	$16, %esp 						#recover stack
	movl	$0, %eax 						#some times it use xorl to clear(like 161); some times use move
	movl	-12(%ebp), %ecx
	xorl	%gs:20, %ecx 	 				#make sure the value on stack not destroyed				
	je	.L3
	call	__stack_chk_fail_local 			#canary
.L3:
	leal	-8(%ebp), %esp
	popl	%ecx
	.cfi_restore 1
	.cfi_def_cfa 1, 0
	popl	%ebx
	.cfi_restore 3
	popl	%ebp 							#recover value
	.cfi_restore 5
	leal	-4(%ecx), %esp
	.cfi_def_cfa 4, 4
	ret
	.cfi_endproc
.LFE0:
	.size	main, .-main
	.globl	gcd
	.type	gcd, @function
gcd: 										#basicly same as -m64
.LFB1:
	.cfi_startproc
	pushl	%ebp
	.cfi_def_cfa_offset 8
	.cfi_offset 5, -8
	movl	%esp, %ebp
	.cfi_def_cfa_register 5
	subl	$16, %esp
	call	__x86.get_pc_thunk.ax
	addl	$_GLOBAL_OFFSET_TABLE_, %eax
	jmp	.L5
.L8:
	movl	8(%ebp), %eax
	cmpl	12(%ebp), %eax
	jle	.L6
	movl	8(%ebp), %eax
	subl	12(%ebp), %eax
	jmp	.L7
.L6:
	movl	12(%ebp), %eax
	subl	8(%ebp), %eax
.L7:
	movl	%eax, -4(%ebp)
	movl	12(%ebp), %eax
	movl	%eax, 8(%ebp)
	movl	-4(%ebp), %eax
	movl	%eax, 12(%ebp)
.L5:
	movl	8(%ebp), %eax
	cmpl	12(%ebp), %eax
	jne	.L8
	movl	12(%ebp), %eax
	leave
	.cfi_restore 5
	.cfi_def_cfa 4, 4
	ret
	.cfi_endproc
.LFE1:
	.size	gcd, .-gcd
	.section	.text.__x86.get_pc_thunk.ax,"axG",@progbits,__x86.get_pc_thunk.ax,comdat
	.globl	__x86.get_pc_thunk.ax
	.hidden	__x86.get_pc_thunk.ax
	.type	__x86.get_pc_thunk.ax, @function
__x86.get_pc_thunk.ax:
.LFB2:
	.cfi_startproc
	movl	(%esp), %eax
	ret
	.cfi_endproc
.LFE2:
	.section	.text.__x86.get_pc_thunk.bx,"axG",@progbits,__x86.get_pc_thunk.bx,comdat
	.globl	__x86.get_pc_thunk.bx
	.hidden	__x86.get_pc_thunk.bx
	.type	__x86.get_pc_thunk.bx, @function
__x86.get_pc_thunk.bx:
.LFB3:
	.cfi_startproc
	movl	(%esp), %ebx
	ret
	.cfi_endproc
.LFE3:
	.hidden	__stack_chk_fail_local
	.ident	"GCC: (Ubuntu 6.2.0-5ubuntu12) 6.2.0 20161005"
	.section	.note.GNU-stack,"",@progbits
```

----------------------------------------------------
with option "-m64" using clang:
(basicly same as code using gcc)

```
	.text
	.file	"gcd.c"
	.globl	main
	.align	16, 0x90
	.type	main,@function
main:                                   # @main
	.cfi_startproc
# BB#0:
	pushq	%rbp
.Ltmp0:
	.cfi_def_cfa_offset 16
.Ltmp1:
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
.Ltmp2:
	.cfi_def_cfa_register %rbp
	subq	$16, %rsp
	movabsq	$.L.str, %rdi
	leaq	-4(%rbp), %rsi
	leaq	-8(%rbp), %rdx
	movb	$0, %al
	callq	__isoc99_scanf
	movl	-4(%rbp), %edi
	movl	-8(%rbp), %esi
	movl	%eax, -12(%rbp)         # 4-byte Spill
	callq	gcd
	movabsq	$.L.str.1, %rdi
	movl	%eax, %esi
	movb	$0, %al
	callq	printf
	xorl	%esi, %esi
	movl	%eax, -16(%rbp)         # 4-byte Spill
	movl	%esi, %eax
	addq	$16, %rsp
	popq	%rbp
	retq
.Lfunc_end0:
	.size	main, .Lfunc_end0-main
	.cfi_endproc

	.globl	gcd
	.align	16, 0x90
	.type	gcd,@function
gcd:                                    # @gcd
	.cfi_startproc
# BB#0:
	pushq	%rbp
.Ltmp3:
	.cfi_def_cfa_offset 16
.Ltmp4:
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
.Ltmp5:
	.cfi_def_cfa_register %rbp
	movl	%edi, -4(%rbp)
	movl	%esi, -8(%rbp)
.LBB1_1:                                # =>This Inner Loop Header: Depth=1
	movl	-4(%rbp), %eax
	cmpl	-8(%rbp), %eax
	je	.LBB1_6
# BB#2:                                 #   in Loop: Header=BB1_1 Depth=1
	movl	-4(%rbp), %eax
	cmpl	-8(%rbp), %eax
	jle	.LBB1_4
# BB#3:                                 #   in Loop: Header=BB1_1 Depth=1
	movl	-4(%rbp), %eax
	subl	-8(%rbp), %eax
	movl	%eax, -16(%rbp)         # 4-byte Spill
	jmp	.LBB1_5
.LBB1_4:                                #   in Loop: Header=BB1_1 Depth=1
	movl	-8(%rbp), %eax
	subl	-4(%rbp), %eax
	movl	%eax, -16(%rbp)         # 4-byte Spill
.LBB1_5:                                #   in Loop: Header=BB1_1 Depth=1
	movl	-16(%rbp), %eax         # 4-byte Reload
	movl	%eax, -12(%rbp)
	movl	-8(%rbp), %eax
	movl	%eax, -4(%rbp)
	movl	-12(%rbp), %eax
	movl	%eax, -8(%rbp)
	jmp	.LBB1_1
.LBB1_6:
	movl	-8(%rbp), %eax
	popq	%rbp
	retq
.Lfunc_end1:
	.size	gcd, .Lfunc_end1-gcd
	.cfi_endproc

	.type	.L.str,@object          # @.str
	.section	.rodata.str1.1,"aMS",@progbits,1
.L.str:
	.asciz	"%d %d"
	.size	.L.str, 6

	.type	.L.str.1,@object        # @.str.1
.L.str.1:
	.asciz	"%d"
	.size	.L.str.1, 3


	.ident	"clang version 3.8.1-12ubuntu1 (tags/RELEASE_381/final)"
	.section	".note.GNU-stack","",@progbits
```


---------------------------------------------------------------------------
with option "-m32" using clang:
there are less symbols and code is greatly simplified

```

	.text
	.file	"gcd.c"
	.globl	main
	.align	16, 0x90
	.type	main,@function
main:                                   # @main
# BB#0:
	pushl	%ebp
	movl	%esp, %ebp
	subl	$40, %esp
	leal	.L.str, %eax
	leal	-4(%ebp), %ecx 				#prepare stack
	leal	-8(%ebp), %edx				
	movl	%eax, (%esp)                #caller func save register
	movl	%ecx, 4(%esp)
	movl	%edx, 8(%esp)
	calll	__isoc99_scanf 
	movl	-4(%ebp), %ecx 				
	movl	-8(%ebp), %edx
	movl	%ecx, (%esp)
	movl	%edx, 4(%esp)
	movl	%eax, -12(%ebp)         # 4-byte Spill
	calll	gcd
	leal	.L.str.1, %ecx
	movl	%ecx, (%esp) 			#source
	movl	%eax, 4(%esp) 			#return value
	calll	printf
	xorl	%ecx, %ecx
	movl	%eax, -16(%ebp)         # 4-byte Spill
	movl	%ecx, %eax
	addl	$40, %esp 				#recover stack
	popl	%ebp
	retl
.Lfunc_end0:
	.size	main, .Lfunc_end0-main

	.globl	gcd
	.align	16, 0x90
	.type	gcd,@function
gcd:                                    # @gcd
# BB#0:
	pushl	%ebp
	movl	%esp, %ebp
	subl	$16, %esp
	movl	12(%ebp), %eax
	movl	8(%ebp), %ecx
	movl	%ecx, -4(%ebp)
	movl	%eax, -8(%ebp)
.LBB1_1:                                # =>This Inner Loop Header: Depth=1
	movl	-4(%ebp), %eax
	cmpl	-8(%ebp), %eax
	je	.LBB1_6
# BB#2:                                 #   in Loop: Header=BB1_1 Depth=1
	movl	-4(%ebp), %eax
	cmpl	-8(%ebp), %eax
	jle	.LBB1_4
# BB#3:                                 #   in Loop: Header=BB1_1 Depth=1
	movl	-4(%ebp), %eax
	subl	-8(%ebp), %eax
	movl	%eax, -16(%ebp)         # 4-byte Spill
	jmp	.LBB1_5
.LBB1_4:                                #   in Loop: Header=BB1_1 Depth=1
	movl	-8(%ebp), %eax
	subl	-4(%ebp), %eax
	movl	%eax, -16(%ebp)         # 4-byte Spill
.LBB1_5:                                #   in Loop: Header=BB1_1 Depth=1
	movl	-16(%ebp), %eax         # 4-byte Reload
	movl	%eax, -12(%ebp)
	movl	-8(%ebp), %eax
	movl	%eax, -4(%ebp)
	movl	-12(%ebp), %eax
	movl	%eax, -8(%ebp)
	jmp	.LBB1_1
.LBB1_6:
	movl	-8(%ebp), %eax
	addl	$16, %esp
	popl	%ebp
	retl
.Lfunc_end1:
	.size	gcd, .Lfunc_end1-gcd

	.type	.L.str,@object          # @.str
	.section	.rodata.str1.1,"aMS",@progbits,1
.L.str:
	.asciz	"%d %d"
	.size	.L.str, 6

	.type	.L.str.1,@object        # @.str.1
.L.str.1:
	.asciz	"%d"
	.size	.L.str.1, 3


	.ident	"clang version 3.8.1-12ubuntu1 (tags/RELEASE_381/final)"
	.section	".note.GNU-stack","",@progbits

	```