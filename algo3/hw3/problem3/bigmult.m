function result=bigmult(a,b)
% This function takes as input row vectors "a" and "b", and, treating each
% entry as a digit of a large number, returns the product of these two
% numbers in the same format. For example, bigmult([5 0],[1 4]) returns
% [7 0 0].
na=length(a);
nb=length(b);
a=[a zeros(1,nb-1)];
b=[b zeros(1,na-1)];
c=ifft(fft(a).*fft(b));
l=na+nb-1;
c=fliplr([0 c]);
for i=1:l
    tmp=floor(c(i)/10);
    c(i+1)=tmp+c(i+1);
    c(i)=mod(c(i),10);
end
c=int8(c);
result=fliplr(c)
end
