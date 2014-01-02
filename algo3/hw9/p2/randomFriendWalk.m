function fr=randomFriendWalk()
% This function takes no inputs and outputs a matrix fr which is produced
% by constructing the matrix of {0,1} entries
%      f=triu(rand(3000)<.2+.1*blkdiag(ones(1000),ones(1000),ones(1000)),1); f=f+f';
% and then dividing each column by the sum of the entries in that column to
% form a matrix of probabilities

szRoot = 1000;

fr = zeros(szRoot * 3, szRoot * 3);
f=triu(rand(szRoot * 3)<.2+.1*blkdiag(ones(szRoot),ones(szRoot),ones(szRoot)),1); f=f+f';
sum_col = sum(f,1);

for i = 1:size(fr,1)
    for j = 1:size(fr,2)
        if sum_col(j) ~= 0  
            fr(i,j) = f(i,j)/sum_col(j); 
        end
    end
end
