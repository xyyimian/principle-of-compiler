'''Expression recognizer.
Handles expression described in expr.g4.
Grammar file should be compiled by antlr4 with option '-Dlanguage=Python3' before executing this.
Module 'antlr4' is required.
'''
import antlr4
import PlusFirstLexer
import PlusFirstParser
import PlusFirstListener
import MultFirstLexer
import MultFirstParser
import MultFirstListener
from typing import Mapping


class MListener(MultFirstListener.MultFirstListener):
    '''Listener doing calculation based on recognized input.
    '''

    def __init__(self):
        pass

    def exitMult(self, ctx: MultFirstParser.MultFirstParser.MultContext):
        print(ctx.getChild(1),end = ' ')

    def exitNum(self, ctx: MultFirstParser.MultFirstParser.NumContext):
        print(ctx.getChild(0),end = ' ')

    def exitPlus(self, ctx: MultFirstParser.MultFirstParser.PlusContext):
        print(ctx.getChild(1),end = ' ')

    def exitParen(self, ctx: MultFirstParser.MultFirstParser.ParenContext):
        print(ctx.getChild(0) + ctx.getChild(1) + ctx.getChild(2),end = ' ')

class PListener(PlusFirstListener.PlusFirstListener):
    '''Listener doing calculation based on recognized input.
    '''

    def __init__(self):
        pass

    def exitMult(self, ctx: PlusFirstParser.PlusFirstParser.MultContext):
        print(ctx.getChild(1),end = ' ')

    def exitNum(self, ctx: PlusFirstParser.PlusFirstParser.NumContext):
        print(ctx.getChild(0),end = ' ')

    def exitPlus(self, ctx: PlusFirstParser.PlusFirstParser.PlusContext):
        print(ctx.getChild(1),end = ' ')

    def exitParen(self, ctx: PlusFirstParser.PlusFirstParser.ParenContext):
        print(ctx.getChild(0) + ctx.getChild(1) + ctx.getChild(2),end = ' ')



if __name__ == '__main__':
    s = input('Please enter a expression: ')
    
    PARSER = MultFirstParser.MultFirstParser(antlr4.CommonTokenStream(MultFirstLexer.MultFirstLexer(
        antlr4.InputStream(s))))
    PARSER.addParseListener(MListener())
    print('The postorder expr processed by MultFirst.g4 is: ')
    print(PARSER.exp())

    print()

    PARSER = PlusFirstParser.PlusFirstParser(antlr4.CommonTokenStream(PlusFirstLexer.PlusFirstLexer(
        antlr4.InputStream(s))))
    PARSER.addParseListener(PListener())
    print('The postorderexpr processed by PlusFirst.g4 is: ')
    print(PARSER.exp())
