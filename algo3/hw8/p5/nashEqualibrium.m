function [x, fval, exitflag, output, lambda]=nashEqualibrium()
    f = [
            0; 0; 0; 1
        ];

    A = [
            [0 -1 1 -1];
            [1 0 -1 -1];
            [-1 1 0 -1]
        ] .* -1;

    Aeq = [ 1 1 1 0 ];

    b = [0 0 0];

    beq = [1];

    lb = zeros(4, 1);

    [x, fval, exitflag, output, lambda] = linprog(f, A, b, Aeq, beq, lb);
