import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * The structure of Expression Tree is a binary tree to evaluate certain
 * expressions. All leaves of the Expression Tree have an number string value.
 * All non-leaves of the Expression Tree have an operator string value.
 *
 * Now, given an expression array, build the expression tree of this expression,
 * return the root of this expression tree.
 *
 * Have you met this question in a real interview? Yes Example For the
 * expression (2*6-(23+7)/(1+2)) (which can be represented by ["2" "*" "6" "-"
 * "(" "23" "+" "7" ")" "/" "(" "1" "+" "2" ")"]).
 *
 * The expression tree will be like
 *
 *                [ - ]
 *             /          \
 *        [ * ]              [ / ]
 *      /     \           /         \
 *    [ 2 ]  [ 6 ]      [ + ]        [ + ]
 *                     /    \       /      \
 *                   [ 23 ][ 7 ] [ 1 ]   [ 2 ] .
 *
 * After building the tree, you just need to return root node [-].
 *
 * [Source]     - {@linkplain http://www.lintcode.com/en/problem/expression-tree-build/}
 * [Difficulty] - Hard
 *
 */
public class stk_expression_tree_build
{
    public class ExpressionTreeNode
    {
        public String symbol;
        public ExpressionTreeNode left, right;

        public ExpressionTreeNode(String symbol)
        {
            this.symbol = symbol;
            this.left = this.right = null;
        }
    }

    public ExpressionTreeNode build(String[] expression)
    {
        int n = expression.length;
        List<Integer> precedences = new ArrayList<>();
        List<String> symbols = new ArrayList<>();
        int base = 1;

        for (int i = 0; i < n; i++) {
            String exp = expression[i];

            if ("-".equals(exp)) {
                precedences.add(1 + base);
                symbols.add(exp);
            } else if ("+".equals(exp)) {
                precedences.add(1 + base);
                symbols.add(exp);
            } else if ("*".equals(exp)) {
                precedences.add(2 + base);
                symbols.add(exp);
            } else if ("/".equals(exp)) {
                precedences.add(2 + base);
                symbols.add(exp);
            } else if ("(".equals(exp)) {
                base += 10;
            } else if (")".equals(exp)) {
                base -= 10;
            } else {
                precedences.add(Integer.MAX_VALUE);
                symbols.add(exp);
            }
        }
        symbols.add("-");
        precedences.add(Integer.MIN_VALUE);

        Stack<Integer> stkPrecedence = new Stack<>();
        Stack<ExpressionTreeNode> stkNode = new Stack<>();
        for (int i = 0; i < symbols.size(); i++) {
            int val = precedences.get(i);
            String symbol = symbols.get(i);
            ExpressionTreeNode node = new ExpressionTreeNode(symbol);

            while (!stkPrecedence.isEmpty()) {
                int pval = stkPrecedence.peek();
                ExpressionTreeNode pnode = stkNode.peek();

                if (pval < val) {
                    break;
                }

                stkPrecedence.pop();
                stkNode.pop();

                if (stkPrecedence.isEmpty() || stkPrecedence.peek() < val) {
                    node.left = pnode;
                } else {
                    stkNode.peek().right = pnode;
                }
            }

            stkPrecedence.push(val);
            stkNode.push(node);
        }

        return stkNode.peek().left;
    }
}
