function table=createVLC(nums,vals)
% This function outputs table defining a variable-length code, in terms of two
% inputs: nums describes how many codewords there are for each codeword 
% length starting with 1; and vals stores the values that the different
% codewords represent, and should thus have sum(nums) entries.
% For example, createVLC([0 1 3],[9 0 14 7]) defines a variable-length code
% where there are 0 codewords of length 1, 1 codeword of length 2, and 3
% codewords of length 3, and further, that "9" should be encoded with a
% codeword of length 2, and each of "0", "14", and "7" should be encoded
% with a codeword of length 3. This function unambiguously defines
% codewords, so that each time a codeword is created, it is the
% lexicographically smallest codeword available. Thus 
% createVLC([0 1 3],[9 0 14 7]) should return the table
% [2 -9 0 5 -7;4 3 -14 0 0]
% or something that decodes identically.

code=0; %% the next codeword to be used, as suggested by the JPEG spec
count=1; %% the index of the entry in vals to be inserted
table=[0;0]; %% the initial empty code table
for len=1:length(nums) %% loop through all lengths "len":
    for j=1:nums(len) %% for each codeword to be inserted of length "len":
        enc=dec2bin(code,len)-48; %% compute the length-"len" binary encoding of code

%% your code goes here!!
% insert vals(count) into the binary tree at the location specified by
% "enc", where the binary tree is represented as a two-row table, "table"

        col=1;
        for pos=1:length(enc)-1
            row=enc(pos)+1; %% pick the bit and choose the branch
            if table(row,col)==0 %% construct internal node and new level if needed
                table(row,col)=length(table(row,:))+1; %% new internal node
                table=[table [0;0]]; %% new empty level
            end
            col=table(row,col); %% jump to next level
        end
        table(enc(end)+1,col)=-1*vals(count); %% append leaf
        code=code+1; %% move 
        count=count+1; %%
    end
    code=code*2;
end
