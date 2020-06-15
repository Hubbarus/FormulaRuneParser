package tests;

import org.junit.Assert;
import org.junit.Test;
import source.FormulaRuneParser;

public class ParserTest {

    @Test
    public void parserTest() {

        Assert.assertEquals(6, FormulaRuneParser.solveExpression("-7715?5--484?00=-28?9?5"));
        Assert.assertEquals(6, FormulaRuneParser.solveExpression("123*45?=5?088"));
        Assert.assertEquals(-1, FormulaRuneParser.solveExpression("19--45=5?"));
        Assert.assertEquals(0, FormulaRuneParser.solveExpression("-5?*-1=5?"));
        Assert.assertEquals(5,FormulaRuneParser.solveExpression("??*??=302?"));
        Assert.assertEquals(2,FormulaRuneParser.solveExpression("?*11=??"));
        Assert.assertEquals(2,FormulaRuneParser.solveExpression("??*1=??"));
        Assert.assertEquals(-1, FormulaRuneParser.solveExpression("??+??=??"));
    }
}
