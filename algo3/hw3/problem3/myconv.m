function result=myconv(a,b)
% This function takes as input row vectors "a" and "b", and returns their
% convolution in the variable "result". For example, myconv([1 2],[3 4 5])
% should return [3 10 13 10]
na=length(a);
nb=length(b);
a=[a zeros(1,nb-1)];
b=[b zeros(1,na-1)];
result=ifft(fft(a).*fft(b));
end
