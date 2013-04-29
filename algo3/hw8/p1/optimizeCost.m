function [x, fval, exitflag, output, lambda]=optimizeCost()
    f = [
            3400; -1600; 
            3400; -1600;
            3400; -1600;
            3400; -1600;
            3400; -1600;
            3400; -1600;
        ];

    A = [
            [-150   100     0       0       0       0       0       0       0       0       0       0];
            [0      0       -150    100     0       0       0       0       0       0       0       0];
            [0      0       0       0       -150    100     0       0       0       0       0       0];
            [0      0       0       0       0       0       -150    100     0       0       0       0];
            [0      0       0       0       0       0       0       0       -150    100     0       0];
            [0      0       0       0       0       0       0       0       0       0       -150    100];
        ];

    Aeq = [
            [1      0       0       0       0       0       0       0       0       0       0       0];
            [-0.9   -1      1       0       0       0       0       0       0       0       0       0];
            [0      0       -0.9    -1      1       0       0       0       0       0       0       0];
            [0      0       0       0       -0.9    -1      1       0       0       0       0       0];
            [0      0       0       0       0       0       -0.9    -1      1       0       0       0];
            [0      0       0       0       0       0       0       0       -0.9    -1      1       0]
        ];

    b = [ -8000; -9000; -7000; -10000; -9000; -11000 ];

    beq = [ 60; 0; 0; 0; 0; 0 ];

    lb = zeros(12, 1);

    [x, fval, exitflag, output, lambda] = linprog(f, A, b, Aeq, beq, lb);