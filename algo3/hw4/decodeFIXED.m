function [out,pos]=decodeFIXED(bits,pos,len)
% Given a sequence of bits, a starting position, and a length, this 
% function interprets bits(pos+(0:len-1)) in binary, storing it as "out", 
% and lets pos=pos+len.
% Then, if out is less than 2^(len-1), the function subtracts (2^len)-1
% from out. For example, [out,pos]=decodeFIXED([0 1 1 0 1 0 1 1 0],4,5) 
% should return out=-20 and pos=9. It is valid for len to be 0, in which
% case pos will not advance, and out will be 0.

if len==0 % pos will not advance
    out=0;
else
    numstr=num2str(bits(pos+(0:len-1)));
    numdec=bin2dec(numstr);
    if numdec<2^(len-1) %% if out is less than 2^(len-1), then subtraction
        out=numdec-((2^len)-1);
    else
        out=numdec;
    end
end
pos=pos+len;
end
