function result=roundup235(n)
result=n*2*3*5;
for k=0:log(n)/log(5)+1
	for j=0:log(n)/log(3)+1
		for i=0:log(n)/log(2)+1
			ru=2^i*3^j*5^k;
			if(n<ru)
			result=min(ru,result);
			end
		end
	end
end
