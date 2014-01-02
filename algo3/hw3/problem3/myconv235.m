function result=myconv235(a,b)
% This function takes as input row vectors "a" and "b", and returns their
% convolution in the variable "out". For example, myconv([1 2],[3 4 5])
% should return [3 10 13 10]. Each of the Fourier transforms in this
% function has a size which is a product of powers of 2,3, and 5, as
% computed by roundup235
na=length(a);
nb=length(b);
l=na+nb-1;
a=[a zeros(1,roundup235(l)-na)];
b=[b zeros(1,roundup235(l)-nb)];
t=ifft(fft(a).*fft(b));
t=[t(1,1:l)];
result=t;
end
