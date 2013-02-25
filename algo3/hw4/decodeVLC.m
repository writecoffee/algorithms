function [out,pos]=decodeVLC(bits,pos,table)
% The input is an array of bits, a starting position "pos", and a table
% representing the code; the output is the nonnegative number encoded starting 
% at position "pos" in "bits"; pos is updated to the new position reached in 
% the array "bits".
% Thus [out,pos]=decodeVLC([0 0 1 0 1 0 0 0 0 1 1 1 1 0], 6, [2 4 -17 -10;3
% 0 -4 -2]) should return 10 and 9, indicating that the given bitstring,
% starting at location 6, will decode to "10", which is encoded using 3
% bits of the string and hence will leave us at position "9" in the string.

col=1;
while col>0
    if bits(pos)==0
        row=1;
    else
        row=2;
    end
    col=table(row,col); %% traversing the binary tree
    pos=pos+1;
end
out=abs(col),pos
end
