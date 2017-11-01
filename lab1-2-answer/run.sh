#! /bin/sh
alias antlr4='java org.antlr.v4.Tool'
antlr4 *.g4 -Dlanguage=Python3
python3 expr_process.py