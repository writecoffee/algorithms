./L1Regression.m                                                                                    0000600 0112121 0112333 00000001746 12134061720 014125  0                                                                                                    ustar   silao_xu                        silao_xu                                                                                                                                                                                                               function [f,A,b,Aeq,beq,LB,UB]=L1Regression(x,y)
% Given vectors x, y that represent a series of points in the plane,
% returns parameters f, A, b, Aeq, beq, LB, UB, designed to be used as
% inputs to Matlab's linear programming routine, 
%   out = linprog(f,A,b,Aeq,beq,LB,UB)
% where the first two entries of the resulting vector "out" should
% represent the slope and intercept of the line that has minimal "max
% distance" from the input points.

n   = size(x, 2);

f   = [zeros(2, 1); ones(n, 1)];

% constraints for Zi (i from 1 to n), Zi >= 0
Az  = [zeros(n, 2), -1 .* eye(n)];

% constraints for |pXi + q - Yi| <= Zi
Ac  = [x', ones(n, 1)];

% constraints for |pXi + q - Yi| >= -Zi
Ap  = [Ac, Az(:, 3 : n + 2)];

An  = [Ac .* -1, Az(:, 3 : n + 2)];

A   = [Ap; An; Az];

b   = [ones(n, 1) .* y'; ones(n, 1) .* y' .* -1; zeros(n, 1)];

Aeq = [];
beq = [];
LB  = []; % this is how you make sure each variable is nonnegative, if this is what you want
UB  = [];
                          ./hw8.pdf                                                                                           0000600 0112121 0112333 00000155167 12133571040 012642  0                                                                                                    ustar   silao_xu                        silao_xu                                                                                                                                                                                                               %PDF-1.4
%�쏢
5 0 obj
<</Length 6 0 R/Filter /FlateDecode>>
stream
x��\I�I�k��Ρ U�+�}�4 ��%�������/̘_�{��Ȋ�ʪ���h�q�2#�m��""��p&6���^����'ns��"����W����_\��w�����g���˂�zs��"M#6R���q��|q��ϧ���h���OΔ�~+�OŬ�bk��e�r%�n�)/b��8L	o�7���a\p��4���R�/'x���^�s��Wv�9N˙�?��<�F˿]~�	,X�X���
~������	0�x�K%��=��4�N#+�Io������Rm�O�	�=��d�;�)��P~���3o��f���Fo�!q�9��/۟O��ɶ��b܁(�W0���*���*��`Np�u�9�ʂ1��	��m���'Ä�Q^@2�;D��]H��yɬw�s@��� ��(P
�܂F�����M'Y6���������w0����ȴa�i+�i ��Q��h��g�j��|�qU�|��C� ������L�-��8��2��t.�fu ]�(�,�l��iM�3�@-�D]�Z� �%�r��A���Ԡ>Y�f�`J����Y�Hi�Uŉ�?�N��z�`��kv��3{�:U�lߑY_⪀.��%�o����"+b�.�Y;��c�.T8�h�Ex_N;�T�R�I��X��F�< c��	MG��%�@	-d�k �8���&�ZyU~�TVU ��c�0�+/���q���a�m1�0������;p,iɫZ� QY:��Wc�`��B��o�+j��m�Y	��j�E	Px��W�Td�(K�}2�<U���P�v6�c�y�l!�Y�(�w�: Y��ZwE�;p9Q���(*]����	,��|Q�6��O�(���V/PUK<C
�LMA N9�H���.��0)�k�Qǉ:�SB;99/�%��=�p���g
|\ ��y��=�1�6��IӃ.��>FC �+:�Q˃���<RAӅ3�[1JC��}w�b���m\�9��PDb_2ʐp�� � ��#0e)1�4$]WSn�5D���7�ѥ��.��pN��3�BtJ
�W���9���$�UjK5�`�A��	�Y��ɼ%�C��Ɇ�(�>0w/pp��7��?,��?�J���.�{CW��H�@q?b�g�B �<��m�Rq�.�V�!����Z*ޜ'c>ř�w���S��!� ��1�[�#<��$f�"� ��=�s9�TD��L�tM�3��=`�ˁ_'a��V�l4Vr� B���'V��YV�i�L�&^��=� ��}�*I����)0Cn)4�/-W�W�BE���	���A�$�ĕ�f��S�ӿ� �:�UpVQ�U�pMkd�s9H�ɘ"�)z�석�7n�D�Xc5���b���s���
y��|���$T'��,\���H�C!ph�+_Aa��Et��ȥ$�D�l��]�2Z��$%0�!�� �'�䊲M2��j�1�u_pL���|6��5��+ u���x>��V�3�X� a�XX�VC�d�-�}���_	X1!X�x0\���@GV��gu�&CFR;wSgx�3@��n�T�y6V����((�X�*Xoj�� ���ˢ֢�xgJ�w�.}���l78'Ne��R�m��hr\���#qCVĽ�M|q�16�(�G�A.��|�����
A�F}����^폆[�����ڴLJx���Ľ�*��/�9R�3�
���F�.��I�b"|���)�=�f�,���v0�g�}���D��$�l��y�g�5b�8���LnY�s:�A��!I�`ڲ,+ڒ_��W�fMɟ�CQ�	UAu�Ү�L��) ���n���6�ʛ��U��ё��V3��χ�A���1���HK$�6�e��[��uXK�y����=�mQ���XZ��@!�f򂣛K�� >��n��
���j���"���oj����U��f�Iץ�{���T��Ru@�RG:&C�5��rs\.���:l>Mӊ>�n͟��A&���?!x��gUk�V��q�7`_!J(ܑb�&ɭ�v�t2;�����q��w�	�3Ƃ�.c�� ��Uf��<��$l�������4�6��q�Z�2\'SDYꞙQܦ"��Z�*Ct�m��$hİR�<�_DP[Q���� �ӧ6�i�9)�ѻb����e���sأ���3-�V���E�
��%�t��䥾�^ 	���p�Mʐ`��C�O;�D4�}�ƎSR�lWB)�Q�`m5��H�R�tAJ:I5���%��]�в�`� �L0Ȫp(�ف�i�l�q�	�a���t7wP�3U[V6;�����Ab�����yrؽ��&�'��J3=���w��8�qF46j��}��^J�[�����Ipc�+�N\�Hˬ��6� �<%�x�����k���A��ؐ&�Qɫ���YY|�YQ�qo!6�T��q�*`���]g��]�J�Z���i��XC'�X��M�d�qa�:�ĉ�,��n�+
����q\�F^�}�TfY�P�U?H�Τ^Rx-!sW�K�U�B�`+����JZxꫪ��ô\OE-AA�qӷ���g��6�G(!~��NHnf�����AK������}M��[QkҁS�����* �02g��mg�j�+�S3�߉�+�I-���N@tM))˓5I�����	kdGi_ht6�U�yh\wN���" ��W"x�@�����g�ƶVi�j�� �P�d#Đ��&y�ܜ1ۥR�,L�G�åX
Y�7�`�GupN�I��~��T���QeN�Hj�'C���c�0�������@��K�v�Jh'RAD�F��*2j�%���̀%��BjO�=��C& 릆
T��4a�k���^eQגm�F�>�β���Ո�5'����i��I�OD����W��v�"�<�H��
�:EL����:��gB�?'��rv;ۊLy��4a�>��:���ҟwt�'���;K��a�F�>��5�}�[6�H��Q.Rt>����<Ù�Ze�G7� d΋�
���C��8Pep���"`YLk(�~�sx�,�����ʀ���n�O&!b�::5�ODەnEO��Q���c,	9q��U<�y��8<mW*��Z"Kw]���#��܍4$`� ۶n������x�VrU�&Ċs�<�lT�Z���6�kT�R�9�� �9=&8�>������;���$��	�NO�	m���<]��;�z +󳐟�A�6�0�tIh��_��a,<j���	���]�cj���|x��v{�s����s3Î��&�l�N���n�:���g�C�?íX���=���~���}ь�����E\�}|�=����ǹhw�~�:@k�uGӌNĤ�["����-�/t�H�)��(� =Җ�x�st,'mW���y��5��TZ��@�n�!�b�i2!�S��K5~}V�-�т�P��C��ڥ�p�v`7f|��H�',s��n.���jm�6��P��!�94�n�o 3 BnF��aT�)܏ʫ(3As�g�M��`�����N��+�*�}��Zgn8g}�Jb瘕:ޒk�w"����m���N04�����'�{��
��B�Wb�0�r�o�wPq=Iu�`5ެn%�:��[��<��V 4|����v;+;Ur���ET����@.r8tPA
{���#Q̌���_(��P����"E�)�u<w.���L�O-�G�ɡ΢^	=��#����*Ե*{���7Lq-�|(&�R��ݩ�
Lvm��Z̝*�>��T<c��s�_�9sj=�F�v���1z����G�1��
3�aw,R�ꆬ~M%aG	`,�f�'��~�p�ԏ;��Ǿ)��1�0W>eo0v&ă����4���UEjm��Sq�KHY�X��Wa��S��X��Sޥ}�p�Ѽ��'FɇxE���̧��m��k$SNyѩ��Pa���q��d\�0̢x<�T�]	Q"�#���j��*������GҐ��\��}�jN����Hz����FMS�@�`NwUԈ{����4L�%���U�0�����5������*Q�KFq7aQ�yX���1�������!Y���?[���:es��RD�)��C�[I�ll�-q���!�����������b��t�ٹ,���u���9B(�wӚ��N���u�zk;ܛh������5`���gŘ>���-��ϭ׻�{[UX�ޭ���v|�q�5��a��L�ܳ��;s9RDMZe�|B��l�Ot�5ǌW������^�r��nis^�ʬ�0F�W�ܹ宣�,De1�8�nEJ����<�n���ӫ�a��?a��cX��z�ݺ`Ùv��6�[�nw'�+���b�?�p�v���wg�j~�Y���ܣA���x�O	��۟p�}�H�;�� �5��ͮ;��h�Ck�x(9^a���������Gp��S�`t����G��M�}ڡ��fh<�C5Q��z۳�Z	{B*��f{����a���^j~���T?��7�y���NSk(٣]ܹ �9�����|�5�_�P5"���o	U�B�������#�&4����/���F�>N�?�؎z��H
=�����ug��I��+��ϋ�:���R�}��3��n��3��¡'�>�	�w��?����y��T���r>`=�4�9�4�H�����)��T����������*�y.z�|��!�`������oK�s�3�����+�?�Du�p ɮ�s��C�ͺ�UE@�]��!�!L�!r�Ĳ|ۑG��d0Ǖ�/P�/>�C&8^�z��.쯒��[�ޗ�8+��=P{y����5�cc(6?9����6}��;g�mi��P���Bd�����6��'������ɟ۲���W3bH/2��3���Gr�6_�m�4��1_=����OrǛ\4�s�;��~K+8r��� ��k�d�+�B��Mn���j���4�ϖ�>q3�s�ч�c�Q%v@wJ�#9�K}��_\^��o�������Eendstream
endobj
6 0 obj
5096
endobj
36 0 obj
<</Length 37 0 R/Filter /FlateDecode>>
stream
x��][�$7ϯ�7�!��~�B���< %<l�{=�I~=U�t�n��{ng�H�ٙ�]��W�ru��%lC���×7�~e6O���o7_�9~�{z������/7��Ǚ�8�4�rs��&���!F��Ɖ�^�|��#J;�}=�`����a�`qE���@��N9�}����߶��|K�t\lO30�rꟷ��Msns����_}��Nk�V�tЄi�4|2�H����+.�q桛�G��_�)��.�m)�N��+��t������I$�!�����͎��(P�'�}$3`�p��dG��Loҟ���B�����&��p�O*��������Z����%2��;`>'�� �j&=c�dxL��ܴX�%�n�4��Q�$j�u[W2�����ٍ ���^��$��c7>��1IO\2-��m��C�t�Z�,f2"����_;�%.��>���l���H�5M�b�)�<?{�`�%zIl[��-v��\��XKܒP/�C�棨�`<a$--e�%m��$-�*6I��B)iE�HY9c�����a�P��n�A���W��Qj�����Y.%���љi���@:�-�Cr�Ģ��Q�"��!mo��J��EXm��6�i��k�u[�/����6� ]!qE���UR�AH����a؂��@Q/�$�&,��-Hދ��v^m��s㍷[�2G�(y�'����8����pۧ��9��M�k?�-y���قԽ��I�o�¨hK=б(up�n�H�rɍ�ĵ�2W�B�e�]�̫m�2W����}�$`5F��h���	Ӗ�Q�>��,[��!]��Rk�}U�ʖ��ϊx�$�z�e���ۦ�w'x�@K\�~�z}8N/d��,��f;0	�EK�£�*��38c �8�v`�R0����iSp�Ms���R���Y�6�!��O��4�I_��סo\[Ӥn����E�[@�kla����5�N<��9p�����D$�y�%\�6��ZI�7a���no�v�1M��IS�����4�Kh�F�Q�+;~�a���)&��S@;1�@����1��F"xZg\����}t�A��h
q+gp��N.��l���<�x���Z�$~��L$ ��X;eɲ��X��r%���M8?�_f���V)�^ʕ�kP�)��=�cG�
��Ppd���e���c�,�O�˒b�Q�)ڴ飊FK|�Σ��6��sL>���Q�2W���\iiK'W�|Sp2�&�T�yt�g�P�����S��v�� �9:��i2���,@��- W�l�M�>����#�S�B��{q
�&x��1͜�����"�`.Ea.�J���w���õ�ӯo1�1�y�r	�����4�ep��a�����S��Hℯ��5�8�+�58�i�� -�������H7��D��T�p>����R��zr�����D�w<��%���S6w����)�c�R�c���%��$+�|M�%92	Eiա3�j�A+;_-=�Z�l�X�V3B&�:б|t�����:�A@��L6���"�Q@2�B:��$_���Ÿ�-�~�
����� �	�����AB\OCB���:��W(dW|><HZ5��"PpC���A�T&�c��8�>��`���MPi>�^F��Y� �x6��K�mt��[�u>����@v����� h㗖�4���ij �Oh���>P������?�9J�b|�Lk�Ч�aeɰ(�^0�#���FC�����p�6�/�ʨ�����2����ch5��Uv�3TLۨ(�x=�Q�Yf-ϧ<^f8�oQ�-'����훤#*�4����Q��m� -hCN��
c���H'D���_���<��x�)�G��F(�a2��ΞM��zx'�����³N�o�|��:� ��qk�Y�-/����3:��Y|������et،��BU�%��Kq��W��J�.���i�qOh[��Nk�mu������y~A���LA��ʜ������AeA���A&~�֞v<����2���7�h�Q����Y�N�	�[_V�ݛ�]�C�jY<��l!��=s{Z����)�������p�M�v5����Hs:B5R\ �M���L�Rg7\w��r���c��$�qv[^3����mU
PnB����v��w;�=�^;��§�$�P�T��a��/��ݟ��0:��Tx����g��4SY���hV�o��b}���̜�fs��Lva�n���sR����֧�b}Y ?MUض�iِ{Ƶ��s.�w_�Py�E��*rD��GG_t����C�����7��Ï`מ;W���,7�G����_00��r*����Yu2��9�-��g�_�3p�$��b��ދ&�j�%��+pf"�#��u��:?x��M���h��������>��pRa��Ҏեw���X��q~�8P6�����x�j9מ2�RK\���Iדr7B����W�������|�����rxջj������������ ��|X���}<VC�G�@՗w��������ո���9BS���>��4 ~��ߪ���/�6�o��.z�]��z���^���,r�"��h�|?��7��z�9��<��
�<h�_� �a{^nZtB����ד�r̎������ʗò���o]��ƹ���@E�Q��4+�W��z=���/^��1Y5����ˇ�Nz��Qo%��I�f���$�~ӏ�ʋ��-�[�SnaWWO\�\�|x����2M��G��מk�S�q\����#�k�����]���+���I���؅5�'�~�D�\O?R�\E1����(f�5e��2�"�!^`Lz�>�օlv�xH_(���ׄ������}B����{�s�������#�8k�#�׷���2�x��;��ى��3�Ύ�ѭ���s�b�%?�(\����ר�iϺz$^4��P=�q�V��>��&k�椺^(o���^~�_�w��+�ľ$L*$mz=9������������z�G�|�9�*u�)��.5�Lz�+dy��,r�{E;K鞹dr)��6�ϛ��/��p=��taKǧ������S��y�`��uWi�M�Wf1WD{�% +�`-�5�_>�0����a\Ur�t��Fd���ح`�����GRH��}��f+�_��b��Ңチ��ș��\H�7XnZ���[�z?���C,.��J��֠��cs���yu˺`�p���K����s� �%F� �?.��G��(�H��o\�}8�E�f-O/� Y���� �r�$)��	}�k��4v�"Ϫ����
Lu���a�V�	�hb�o�:+�Zрo��5��4���GV�g�~"�+��Ϸ���I4����0��$N��ߗ�]�rܮ|U�s^�GYę*k��t@2�/P��)�M����������3S۷w��ވ�c��
�A�L��R�����c�]c�@ �Y'�Ԉ.��N�����������@�)�@�	�O���Kڬ���iD�m��%Nb���k��)��ド}_����}_j��~�v"�Stڊ	��ؼ<�R����M������óES*����r��.����}۪)��B5����k��"R,k�nju�ע�e�7�'�5��*���nk�P�w)��,����9����{���55E�zR&�w�{6���x=o�*�-1�8�˽�;`,�~c����x��v��ܤ�b�q�$�6�,7�M�QS�ҽ��d���Q�QX+�sim�v��a�wR�y���\f�y��0?[hg��V�QS[�QJX���;�JL?��ߥ1kP96]E�%��D�#aR�ہ����A)��	��o�!�^Ӯ�^�cR/&h(zk�np�)�1�-o�dL���:g�[��o��.��7p��ގ�<�.!$�u����̒�fˎ|s���V��IzH$�:��Q9Q~i\��� 9h����"G�z��ͺ��u��:����҆|Ǘ* F�x,�t���O����{qendstream
endobj
37 0 obj
4131
endobj
4 0 obj
<</Type/Page/MediaBox [0 0 612 792]
/Rotate 0/Parent 3 0 R
/Resources<</ProcSet[/PDF /Text]
/ExtGState 33 0 R
/Font 34 0 R
>>
/Contents 5 0 R
>>
endobj
35 0 obj
<</Type/Page/MediaBox [0 0 612 792]
/Rotate 0/Parent 3 0 R
/Resources<</ProcSet[/PDF /Text]
/ExtGState 44 0 R
/Font 45 0 R
>>
/Contents 36 0 R
>>
endobj
3 0 obj
<< /Type /Pages /Kids [
4 0 R
35 0 R
] /Count 2
>>
endobj
1 0 obj
<</Type /Catalog /Pages 3 0 R
/Dests 10 0 R
/Metadata 69 0 R
>>
endobj
7 0 obj
<</Type/ExtGState
/OPM 1>>endobj
33 0 obj
<</R7
7 0 R>>
endobj
34 0 obj
<</R25
25 0 R/R17
17 0 R/R11
11 0 R/R13
13 0 R/R23
23 0 R/R27
27 0 R/R8
8 0 R/R19
19 0 R/R31
31 0 R/R29
29 0 R/R21
21 0 R/R15
15 0 R>>
endobj
44 0 obj
<</R7
7 0 R>>
endobj
45 0 obj
<</R25
25 0 R/R17
17 0 R/R38
38 0 R/R23
23 0 R/R27
27 0 R/R19
19 0 R/R31
31 0 R/R29
29 0 R/R40
40 0 R/R21
21 0 R/R15
15 0 R/R42
42 0 R>>
endobj
25 0 obj
<</BaseFont/BAZZUV+EuropeanComputerModern-ItalicRegular7pt/FontDescriptor 26 0 R/Type/Font
/FirstChar 65/LastChar 121/Widths[ 866 0 0 0 0 0 0 0 0 617 0 0 1042 0 897
0 0 0 662 0 0 0 0 0 0 0 0 0 0 0 0
0 603 0 544 0 544 0 544 0 0 0 0 309 0 662 0
603 0 0 0 398 632 0 0 0 574]
/Encoding/WinAnsiEncoding/Subtype/Type1>>
endobj
17 0 obj
<</BaseFont/JAMKHU+CMMI10/FontDescriptor 18 0 R/Type/Font
/FirstChar 59/LastChar 119/Widths[ 277 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 432 0 0 0 0 0 344 0 0 0 0 0 0
0 0 0 0 361 0 0 715]
/Encoding 61 0 R/Subtype/Type1>>
endobj
61 0 obj
<</Type/Encoding/BaseEncoding/WinAnsiEncoding/Differences[
59/comma]>>
endobj
11 0 obj
<</BaseFont/WBDZBG+EuropeanComputerModern-SmallcapsRegular10pt/FontDescriptor 12 0 R/Type/Font
/FirstChar 50/LastChar 121/Widths[ 553 0 0 0 0 0 553 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 611 786 0 0 0 0 0 0 0 0 0 0 844
0 613 580 591 624 0 0 0 0 302 0 0 513 0 613 635
0 0 0 0 0 613 0 0 613 613]
/Encoding/WinAnsiEncoding/Subtype/Type1>>
endobj
13 0 obj
<</BaseFont/EEAJYZ+EuropeanComputerModern-BoldExtended12pt/FontDescriptor 14 0 R/Type/Font
/FirstChar 49/LastChar 114/Widths[ 562 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
768 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 625 0 0 513 0 0 0 0 0 0 312 937 0 562
0 0 459]
/Encoding/WinAnsiEncoding/Subtype/Type1>>
endobj
38 0 obj
<</BaseFont/EEEWFW+CMR7/FontDescriptor 39 0 R/Type/Font
/FirstChar 48/LastChar 61/Widths[
569 569 569 569 569 569 0 0 0 0 0 0 0 877]
/Encoding/WinAnsiEncoding/Subtype/Type1>>
endobj
23 0 obj
<</BaseFont/YKTBVV+CMSY10/FontDescriptor 24 0 R/Type/Font
/FirstChar 0/LastChar 41/Widths[
777 277 777 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 1000]
/Encoding 62 0 R/Subtype/Type1>>
endobj
62 0 obj
<</Type/Encoding/BaseEncoding/WinAnsiEncoding/Differences[
0/minus/periodcentered/multiply
41/arrowdblright]>>
endobj
27 0 obj
<</BaseFont/OKKPFO+MSAM10/FontDescriptor 28 0 R/Type/Font
/FirstChar 54/LastChar 62/Widths[ 777 0 0 0 0 0 0 0 777]
/Encoding 63 0 R/Subtype/Type1>>
endobj
63 0 obj
<</Type/Encoding/BaseEncoding/WinAnsiEncoding/Differences[
54/lessorequalslant
62/greaterorequalslant]>>
endobj
8 0 obj
<</BaseFont/CAUVDG+EuropeanComputerModern-BoldExtended17pt/FontDescriptor 9 0 R/Type/Font
/FirstChar 49/LastChar 119/Widths[ 539 0 0 0 539 0 539 539 0 0 0 0 0 0 0
0 0 0 779 0 0 0 0 843 0 0 0 0 0 0 0
0 0 0 599 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 489 0 0 0 0 0 569 0 899 0 539
0 0 435 0 0 0 0 779]
/Encoding/WinAnsiEncoding/Subtype/Type1>>
endobj
19 0 obj
<</BaseFont/GTTECJ+CMMI7/FontDescriptor 20 0 R/Type/Font
/FirstChar 105/LastChar 113/Widths[ 404 472 607 0 0 0 0
588 523]
/Encoding/WinAnsiEncoding/Subtype/Type1>>
endobj
31 0 obj
<</BaseFont/WJQWFK+EuropeanComputerModern-ItalicRegular10pt/FontDescriptor 32 0 R/Type/Font
/FirstChar 97/LastChar 121/Widths[ 511 0 460 0 460 0 0 0 307 0 0 255 0 562 511
0 460 422 409 332 537 0 0 0 485]
/Encoding/WinAnsiEncoding/Subtype/Type1>>
endobj
64 0 obj
<</Filter/FlateDecode/Length 186>>stream
x�]�1� EwN�hZe�XҥC�����!�z��I2���y����v�9�({F�ސ��NGX��&�Hs�ڪ�U��,a�]��7 � �Z?���rT�ڣ��%HQ�	H�!z�Cp��צ��%�5�F�R#�l:Ӣđ��UB�W��e�ز����L�#��N�Iq`�|(]4��ba
endstream
endobj
29 0 obj
<</BaseFont/YUIWZA+CMEX10/FontDescriptor 30 0 R/ToUnicode 64 0 R/Type/Font
/FirstChar 0/LastChar 88/Widths[
458 458 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
875 875 0 0 0 0 0 0 0 0 0 0 0 0 0 0
875 875 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 1444]
/Encoding 65 0 R/Subtype/Type1>>
endobj
65 0 obj
<</Type/Encoding/BaseEncoding/WinAnsiEncoding/Differences[
0/parenleftbig/parenrightbig
48/parenlefttp/parenrighttp
64/parenleftbt/parenrightbt
88/summationdisplay]>>
endobj
66 0 obj
<</Filter/FlateDecode/Length 164>>stream
x�]�;�0����7�	�Ѕ�U��!qP�(���o�PK�d����|�n� ��|c mHy���%�!V7��G��\�c|���:�(@]��X���.O��H�psB�� �C�cI��h֗���R��m2sn����A��#�l8JF����.Q�� F�T�
endstream
endobj
40 0 obj
<</BaseFont/CNTUYP+CMSY7/FontDescriptor 41 0 R/ToUnicode 66 0 R/Type/Font
/FirstChar 48/LastChar 48/Widths[
329]
/Encoding 67 0 R/Subtype/Type1>>
endobj
67 0 obj
<</Type/Encoding/BaseEncoding/WinAnsiEncoding/Differences[
48/prime]>>
endobj
21 0 obj
<</BaseFont/FLBTBY+CMR10/FontDescriptor 22 0 R/Type/Font
/FirstChar 40/LastChar 61/Widths[ 388 388 0 777 0 0 0 0
500 500 500 500 500 500 500 500 500 500 0 0 0 777]
/Encoding/WinAnsiEncoding/Subtype/Type1>>
endobj
15 0 obj
<</BaseFont/ZAMMNU+EuropeanComputerModern-RomanRegular10pt/FontDescriptor 16 0 R/Type/Font
/FirstChar 16/LastChar 122/Widths[
333 333 0 0 0 0 0 0 0 0 0 0 555 0 0 0
0 0 0 0 500 833 0 278 389 389 0 0 278 0 278 0
500 500 500 500 500 500 500 500 500 500 278 278 0 0 0 0
0 750 0 0 0 680 653 0 0 361 514 0 0 916 750 778
680 0 0 555 722 0 0 1028 0 0 0 0 0 0 0 0
0 500 555 444 555 444 305 500 555 278 305 528 278 833 555 500
555 528 392 394 389 555 528 722 528 528 444]
/Encoding 68 0 R/Subtype/Type1>>
endobj
68 0 obj
<</Type/Encoding/BaseEncoding/WinAnsiEncoding/Differences[
16/quotedblleft/quotedblright
28/fi
39/quoteright]>>
endobj
42 0 obj
<</BaseFont/VSFKWG+EuropeanComputerModern-BoldExtended10pt/FontDescriptor 43 0 R/Type/Font
/FirstChar 103/LastChar 114/Widths[ 575 0 319 0 0 319 0 639 575
639 0 473]
/Encoding/WinAnsiEncoding/Subtype/Type1>>
endobj
26 0 obj
<</Type/FontDescriptor/FontName/BAZZUV+EuropeanComputerModern-ItalicRegular7pt/FontBBox[0 -209 1112 711]/Flags 32
/Ascent 711
/CapHeight 711
/Descent -209
/ItalicAngle 0
/StemV 166
/XHeight 451
/CharSet(/A/J/M/O/S/a/c/e/g/l/n/p/t/u/y)/FontFile3 46 0 R>>
endobj
46 0 obj
<</Filter/FlateDecode
/Subtype/Type1C/Length 3583>>stream
x�u�i�\�u�[�t!���z��WQ�!��$)���(L�"����G3��ޗ�o��}�z�^fz͌Њ$a U)LHR)I*��J�P����R�ۃ�K����_�w��s���9oGຝ�;v����D,�>�������رp"���$�#�G�OE�O�޶��[7�ܺe�4��kϏH�wI���n������W�ލ�yS`׎?�����x2|ll2��N�?�&�&��������d21~4<�{w���w�M%����ݛ�d����=����%�ƣ�pt�6��"ޱ/�<��#�U�c(��ok ���h<���x����cǟ��<8x:�;����<�+�p�����M(Y����v~{��u��<���w�����W�������{Voܷ����ʨ��8����(�ϒ,I����?%iU^h+�tU7Tc�v}AK�L�iT�v�#7���P�F� p����b��$I��V����bq�������I�#�����Hiy9%�k8�H��c��
�ׄ��)��$1��޲�}/�2,��=����������^�K��� lkb����Xmp��@	�;�G�\������h�C��Wm7-Swt[�\ބ��2�+Y��r�:��EB!\o�ۖW�]��V*�aK��������bz^��n4{ݕƺ�)U��,�s�����QOed��EP�\ZN�Y��hج�9�%آ%��_z�����)�b���J��@
Z�q�F'�T.O3S�	#5�Dg������oV6��n�[̆��6�������c�q6�b$Gq���t.��R-���3Kd�12Z��V`dVA-ad�֧�iST��w�.�W����g�(y�	*Ty� �4���x��4`r��$LR)<'XT|��-�]@���Pg��տ��^�l�6g�Eɴ�T���.[}����A�P)5)���ޅN��]={����vRX�ט����e;��q0?C�R�Ӥ�6)�TC�J)�Ġ�q2y�.�1(�Z��U�������j���rv��ׁ�#�B������|
�a:�˿�88K瘸9<�ՀΚ� t9�wGr%G��Z��l��'���
��'�RMp��z���m�� 
bvGk��h�6��U��3�.�5�a5TS����A�C��$����b�<=O竔�UDO�]�}��.��T�G~����X�):��W����c�οT^W����Q�V&�dp0OO#hvoW��t7�+�z��F�Z�)�� �3)&�}#�t��c��p��Y�ہUP��|�_��֚����̒ETȕ�ef��o�WܕP��b*�L���$��D��څO��e9B�"�L���7�W�*hU��.��;g�%��y���4 K4�A�&��a:I�B���9~�$ �UY���%iU[6/5.�/X��w��ЦZ!d:4�6�U�@>9#>-LL�f	 �ż0�ux��o�u�Q�4�"24W|����uZEh��>����$ncN�����<~=0-e��@�4�`,��55������l�HVt�,txY2-/0,dY�b\���&�d����ʕF��`w̚���(U����Ѯ��gפ���0�����f���W���!�[w�5jM�+/�]�6��Eo�j�M��X�-�)	4���c`��Y���h�P���D�F��CB�\��%� ��Y�1h��)/B� D�V�����ʇ�I{t�G20Q.��j�.>{)a�.r;���.�՚��.w�z�����-�L���v�����B��`僅G�_d	�-�e��K�����(��dv�k��ꜞ��Iu�����r��3����)-�g��,T�U.m�ئ��j�	�rjN�p5-��09���ș܁����Jy0� �
���+vԖ�4�N��!?�0�����h$u�4զL��b���i�D���6r7=i%TgrR�̩@C0H�&w6���Ru�Ů�\y�������;C6V��gH6.���f��P�A�$"��25�%!CF���!��ڗ�tݎ�C�,�/B�mB�!!����Iȹ�����2KP�Hh7��
��f�;(���+�����麮i��R:L�p����r�y����W�QY�I=&<x��EڔÄSk�:������tծ�қf���z�eZ��{�1$��1��9�,NR$]�g�X��2�\����+ôd���L�4'��a�U����څ����r�{��Z�E�����׮}c��o
��A9�����wx�P�	��� ��R`��h�����]�G>	�)֍!��i�I���D(I�����Ʋ���[�����4x�>إ��l�-Pk8�����������҇̑�rj�����Y�,��SbKbQ��RI�h�AA�%����b��(��DJ��4�gt�^�c��^�hM�]�ⶃ�"���5U�U<���
dV
E���RQ.�,!31,v�;��~{��������a�����M	�7����UB"$��`"Ey>�ʤD"���)?3����tY�d\q�O-.y���,`�݂U�g�����p�3�2a��|$$u��fLʦm��Y)�r�'w�Sꦽ^[�z���=�v�+�2�@8�l<�ESӅ����0u�m�
l����!ke�Y���.�O��7Z��@���!*���C�aEV�bL��d�$���$��'��4)!��n�����������95�1�]��K�[�C8�j�N4�N�K.�j��T�V����~���;���<�v���乿���Gz�j�˻�j�I�3��:-���Ѷ�ڰ��A���8�Řȅ_|�x���M1����O���O<�����񡌘V�zQ+%�4)ԑ��	���Qտ�=����5ܖݲ�l��D[7�2��f`���,� ���D>�乼��RrZI�mY���)����i�s����|�ˈP2��ĪCXQ{��X���]qYX������+�W�m�g��Ž��?k5���p�A3��(ȿD��e�%Y���k9�p� y$�:ˏ&=�z���YyV���Ɯ�f�:y2y�=m�[�F!����h5�eԄ�����F��|�8(�j$9,6?�
yD�
5N��*���ZGG��{�������3t�w�B����.颮V�s��M�#*D�^,��+��(��^�_Z�8���b�N��#����S������
��F������X�.��tu�*�	=f��b�rP>$����
IRk�������GK��U�*�p�@B�h�bX6����K�b=�᳍)sZ~@~�ĳ���e"�4��sRV**E���:iP��"B�Ŵ�z�І�U�-8�{M` ����(;"hM�EQz����zD����"�)��^�M�fu�G���8	� H�abvpj� -�C{�����n��}��`p���-�9l�[���_`"l�6�w���|��Tk,y}4�,��Fs�I
4�<�+A�� Ee4���Q��(4�r�`�6.65�j�����M���p��W'��9,�<N�a��	��G�
endstream
endobj
18 0 obj
<</Type/FontDescriptor/FontName/JAMKHU+CMMI10/FontBBox[0 -193 691 661]/Flags 131076
/Ascent 661
/CapHeight 661
/Descent -193
/ItalicAngle 0
/StemV 103
/MissingWidth 500
/XHeight 442
/CharSet(/c/comma/i/t/w)/FontFile3 47 0 R>>
endobj
47 0 obj
<</Filter/FlateDecode
/Subtype/Type1C/Length 888>>stream
x�UQ_Lu���ݰvӤ&szw�,� ����s)�L�f\ 8Q��sײ���Ѯ�Җ���-�B[�t��n���l{�`���٢ك3q${Y��]s�XݓO������*+0Ƿ�;:�4�Kk坸�\���
��қ��*Ш@S�-��42?�z����
ǹ���㝂�$+�u}�tKk������V���L}+�aY�b��}��31���kcE�u�n���d�4q����h�Id�w�F�3F��*҇�~��1�9?(2����aX���3�ðN�k�����RX%&���W*������;rH/�n��	�%ݦZJ���ڣ��� F�=	W��`GI����Q���i�H�=�^)���It^b�|��v�$�0>:��k�L@�}s'��Ҕ��[�k���6^|x����O��u�L�P�9�{�~G�z��[�v�����]�SF ������5��Jfc)����±����Q_&���(�|5����~��\T�R�� ��{�N���F���`��7��\@��ub���%���X0�'��%�&k����Ųǀ���N�R�Vn�fP��Z�|Y�dZޮ7��C�a��3޳+ˋk7z
��Ne�R����U����G���tp,�ɶ:����҃�7Tnc��:���H�'�����g~���U�P��I�y��m��kq!��%����ͮ��/�H��%���kd����Z6�L�������>T���>ۈ�DO���Y@���(�|#��̇��pK���הe��s��G8:�Q�ވ�;a�hv/�.��M��Ǔ�H�Hd�}�=b6S��"��h���h+����drY2jŐܒ���	��r��ٺ�h0�AT�
endstream
endobj
12 0 obj
<</Type/FontDescriptor/FontName/WBDZBG+EuropeanComputerModern-SmallcapsRegular10pt/FontBBox[0 -235 737 718]/Flags 131104
/Ascent 718
/CapHeight 718
/Descent -235
/ItalicAngle 0
/StemV 110
/XHeight 530
/CharSet(/S/T/a/b/c/d/eight/i/l/n/o/two/u/underscore/x/y)/FontFile3 48 0 R>>
endobj
48 0 obj
<</Filter/FlateDecode
/Subtype/Type1C/Length 3024>>stream
x��Wk��u�ZZ��q�(	n��H[Զ��r�n�:��ț؉e[�d{W˕�"�|?���83w�Or��%��ڇ^�=l���pj9��um�@д�[����?��z�G��� 0w�w������������tb.��>2��S����t(��[��p��d,����tx2��?���i��#wܲ�m���Lߜ�m�mw���g���N~�k|ڷmdd�y<%&S����\d|"��|l.��:��L�Ƨ�㑙Tb�Ph����u�]�GR��_�ܙ�f��%�w��LF���Ώ�9��y|��&��!����p�����|�OG�ғ������z:�����}������������}����k��|�|�1�n�g};`�|��~:b��n���_}��������ܭ����'~���}���;G��+�h�=�0�B�*Vi�a�j��X��!�q��d �_p \���%�	���#WFe���/ɫ�8��y����~��s:aT�ʘN�1��uP&�6�E��� ����z[7K�Dt	�r78e�<<%�X�%��SǴ���"(�H��?��}��U��1V�s<��o~ʻ����T�Ó�t&�/fʩ�w��@-�J�疒��������u��.���ּ�u_��7n���d;�0熭�}T��Q5�EG��������Niq9!�<(����z�^��h�&��Y���E%�
�҄������[��M�	�܏�w._3�0u�ptGm��)�s���[���,(��Q�NĄ��_\�9�h�-��t����:o4tר٧Vz��ʲp,����Bǚ�5^��ʪ�h�X��������R]��aTN��ʪ��XY!2����8=��9���2]fL�ˋ%��ZE���N���΁��e���u�_�
M�����.����l�
�=���Cu�|K]�LJ��ȼ���5UWs����<�M���3gE����x���M�z#���z�=�����݄w�n}�s����ˬM�0at�%������?�kAl�tp*��8_�QO�������+_�O����B��	j��Ф[d��`��ӿ#����E��^:�-�>�!�l��?�����i�����Q�����_8,�I�rt���_}��Ă�7��=r98����M^{翃�����ւ�Q���>4L��[��U��Rv�Z �4NU(�ȁ`:<�����'S��k��C^��޳EˍK�(;`]rRJ��>��c�7 1�K)��=Y���ғ����4]�V�l���-Ê0y���©�.�b2&�-��6�S��5��o
V�fM�FڄY����|��Y�>���"�0e�!���d�-�)� z�_���nu�� ��J(�T�*"	*<I����L���:EL���z�y(vΡ/��{�竐,���M�8Y�16FG�9������
 d�`u~��&�AmP���2@��Qa�a��n�3���]��cRI�@	&` ��r`(����p��N�0$��l\ɕ[V�r�_����ӽ���cu�.��T?����"TR�V��yn���gޘ�^��c�p��D���\�����m�n�����/7b3ޟ�O7����!1��	��Gl��pI1�$���6����=ވ�3�ϟ�	j�jCnH�"�4^aA�x��߂��#��S�Q(�(��V�䳱=�s�Q7��-'N��܊�*�(��J}����n�n����{eJ"%JbDZf$�xtI%�Tꠎz�`B��HK�T�\&������#�:����(���t����Bk�����io��7Ju�)Z�f�>�̪G�Y���3�.�N�u.�8�4��ʏUz�Y��eH�I�!�ibJ>�������R���.	�K�M�!q�[�$ȡ"ʰSx�9;��NH��F�Xp�I��D&P�����0������m�\
��.、��D�$�Ơ��]��ج7��߾������[n�[�3�s�oW��eqI��l�M�Q��W��yo�m�M4ˍl'Պ9h�L�u���Q5Q{a1��vU�$K�4׬;�ۜ�u��ޓz�2�L�J+�n�E휑���lP�s��Yʘ&ʆ�Iu���l`�A�ժ�*W���3�|$��ڑ��{����R��fSLB��	���{߈��yv�}�<N��K����A�9�S��&G�h8s��TSbF~R�z�8O��E�s�_� �W�
�pP�_� C��E t�"�;��&+�i�fA.��惁\?3�������c��T]�5[q䞶(.�6��6o6g�&.��܋�o ��X)W���G���Ż6)�ۤx	����RA��*50H�?#���M�1́?���z�'�Xh��͸d�lb&����"r]���}��߱|6v"m�Ѹ�:S��cIGM�T�GU�˰i8['�jB��5�A��h:�W�&�t[�lՑ�r4?��熲�R�o����t6���b<Ke��ͧצ��N���j���~��lؒ�Zs�8���O�N�����/t�����޲�X��h��.%O���Lmו���P8�uJL�+�A�i��=�>�E?8��[9'�`�1Fg̪��.�t��V;ݥz�lk-��qyF�5Z��D�*�b���d%��2�Xn��>�' �e1�#�s���JƝS��"H����׎=EW��=�WO%�so�6����/�6u˰5�Pe��wk�����x�^�E~`Ȣ ��x��6@��7>���_Pp�=�%ɂ$H@�%FcdJ,�fV���������
A1�X��+n�jKn�۾p�q9ު4J���s���#�LL�S�db���o>	=�D�ƪ�
ݸ��{j�����q�*1���P��/
�	���/�}2�n�7�ׯ��j��ڠ͵y�m0uU��:�<�B��Q���S�nT�$����SL��� ��硶������ i��
endstream
endobj
14 0 obj
<</Type/FontDescriptor/FontName/EEAJYZ+EuropeanComputerModern-BoldExtended12pt/FontBBox[0 -12 913 694]/Flags 131104
/Ascent 694
/CapHeight 687
/Descent -12
/ItalicAngle 0
/StemV 136
/XHeight 459
/CharSet(/P/b/e/l/m/o/one/r)/FontFile3 49 0 R>>
endobj
49 0 obj
<</Filter/FlateDecode
/Subtype/Type1C/Length 1236>>stream
x���KlU��y� U)T2�E[\AB�i�bAH��"��BhEi��Ǝ�ֱ{�8�Ǐ��xf�=��=~6�ӤNJ�i�QQ����"U TĂ�΂1�%b�=�su?���W�4A����^��e6:z��./jv�9Mf���CN��5;LfS�k.����=���l��j�ǝ�﵂m�`[��*�P�Q���i�Y�9I���f�5��Cn簾ό{�TƆ]�3c��!�m4���zc�ފ��7��FGG��=�v�>��+d5:F͎��]�'��'�����`�b}�߬!N��1�p7����������)5�	��9�y�D6#�Zt-��ڗJ�������>�����S��Ş�O�>��.u�[�ZY�������7{��qD�i�[����I).R)BL�3~ޗ�qN�Np|`��"($FF)�Sb�l0�q.��
D��I�I��T���W�EPA�*s��uAQHi>�ʥr\>����kG�8T1i&M�1!A��:�k�rهR=�<�*�foȋSK���K������ 8�qOr|>r���O�		��*F����T��C4��N;"�78�cd�
�JsG�f���C*�5Fb%F�tr�A��_�oQqO�#H]%6*�W���ҝŵ�ס{�B��":nڒ��M���3�1'����o=�*"|a��+e΋��P�J ��39:Cg�45�	1�㲏�p��h����Q001����eOv|20���Q�*#Z%�v�-d J|*)!!�YF&o�W�ek�����	�t����e���~�^Dք���,f�|R ���d�X$���A7����W�L�����2XB�ȼ�iK�H��^�
٢�PZf.�2��K���;� ���F�l��� �HI��� no{��G�)���$or��i�tn�|qji���vw��);�ƙәS)[�,k�K���m	T�+^�RkE�:&0��,�	��H���1��`R߮��֮�/�5̫�:LZf6ʎy�:�j�� 4R����?~����w<hؕ�0�ag��Ԭ|�8U���|M�ঘ<&G��	^(R���[�`p#���<.�)��:���J�����8�w��Cx���D��XdK
M��K�,��`1�P������7_�B�?~�}�<<���7�O���d}��-٪���δV�jV��� ��)�������'0�
endstream
endobj
39 0 obj
<</Type/FontDescriptor/FontName/EEEWFW+CMR7/FontBBox[0 -20 806 674]/Flags 65568
/Ascent 674
/CapHeight 674
/Descent -20
/ItalicAngle 0
/StemV 120
/MissingWidth 500
/CharSet(/equal/five/four/one/three/two/zero)/FontFile3 50 0 R>>
endobj
50 0 obj
<</Filter/FlateDecode
/Subtype/Type1C/Length 1006>>stream
x��}Lw��zлiAD�l��;�e��(���B����aV<K�������/Ŗ�Ǘ��(PD� [pc22�����[ #3n3���)�w�pY�?o����ySa8����C�+����J~� 10�4aWWD#�VT��Fa�[*���$o6�Llq������٥ק0��7˙l�P�Z�B�(c��ͬp��}�D��		�(�-�x�7��Ɉf���cm,�1{����&�ha�Y|h8��.�<��g�r��4}��I{0L�mŢ�mX�ŞŨ��e`c�x)���W�ˮ��8����������?�}�ﳁ�~��i�t N�j�}���A?�U;�m>h�#�9�����=4r����m- �s�p����/��8@0@�"r �ަ�2�-��Aq�r�a~�_;�{�f{���`��;�3�� I���,Q�����+��~�GM��@�v����d��e"}0�~j��,�kRw7�-�FaP���aR�Ē;��r����V$��#Tw��=(SkV��5�5ug�Ce=K��2�>�0s�X�P��%F�JNJ�`���7�%u�9�����	�֦�R��3>2�������=/�աF������`z�� q�h ��.~��(Q��Ż�f���2�P�l}ew���sP��^Y[<����t�cc��jI?�
�7�������>���S�э\��6
�W7�I��2�����x��(w�������K(F��)W	y ���B�#{��^u*kt��G�Mh"�4CU��jROzf=�¬{�Ji%S��z�L�_�n��.��?k�m?�vG�%ԼJ�yZ���"t��[������� ��,m�=$��<��5��� ��?��o�SP����Ъ���<�a�������X��񦣶Ȅw%~n��y?R�'���#�����4(���h��Ut��-�E�^�Ё�[[�j��FJ��6�6�%{5���5��NM�����(
endstream
endobj
24 0 obj
<</Type/FontDescriptor/FontName/YKTBVV+CMSY10/FontBBox[0 -25 943 525]/Flags 4
/Ascent 525
/CapHeight 525
/Descent -25
/ItalicAngle 0
/StemV 141
/MissingWidth 500
/CharSet(/arrowdblright/minus/multiply/periodcentered)/FontFile3 51 0 R>>
endobj
51 0 obj
<</Filter/FlateDecode
/Subtype/Type1C/Length 589>>stream
x�-��KSaƿ�͹li��}�
25�0��A72/2S/�<m+w��s�e�q�t���<N71m�@gt#��º����>B�?���c��xxx���}�* !��x{�:ڏ׫z#�/W�WL�?����f�6�w����zʜf��i�ÍF�P (�f���ъ���w��a��},��� ���0�z9�#��VPGo��I����7�n��")$�}F`�g�0�Ǳ"��t
�>.<:.2<�r���x����FN0 8��@	l�Au%3H�-���u��u�[��I�L�����?�O�$vLM%�i���.:`�r*���Rb)KH>���?I/�R�#�]����w���I;�vi7�n�WW��U�d2x��K.Ɠ33��|�Q�ԩ��D���5\(Dp�u�c�F�$��UWݦ}�ׁ�>�s��PdYA`٢P*�%g��$uhԭ�����>�;�n2����P������G߷�>��1������f��;[��}���}��ʪ�(��ar�4�%)%�L�F������\H+/��e˱��\G���o�1�b�Ά�h��h��Yg�������f�� � #�
endstream
endobj
28 0 obj
<</Type/FontDescriptor/FontName/OKKPFO+MSAM10/FontBBox[0 -137 694 636]/Flags 4
/Ascent 636
/CapHeight 636
/Descent -137
/ItalicAngle 0
/StemV 104
/MissingWidth 500
/CharSet(/greaterorequalslant/lessorequalslant)/FontFile3 52 0 R>>
endobj
52 0 obj
<</Filter/FlateDecode
/Subtype/Type1C/Length 466>>stream
x�cd`ab`ddd�v�54 1UH3��a�!���[���O�n�n��?J���~/��^,���Ș_Z�;�9���(3=�DA#YS����\G����R�17�(391O�7�$#57���Q�O�L-�Tа�())���///�K�-��/J���Q(�,�PJ-N-*KMQp��+Q�K�MU�8OB�����&�����&��$��#�������Y�?����9��삟����������ٓ�'uO���W7����3%j'�wwvs4455�M��*�c���?�Դ��v7I6Li����=i�܏�g��9�Wt���9�{~c[Skw�"4+�<�>q҄�iӚ�4�5�w�����{fUsGKw�dws��{ϐ�������1mʔi3��&��Y��GߟQL�=�g�M��nonj "�W���ҩ�g��N�ξ�k3���|�%�xx���� 8��
endstream
endobj
9 0 obj
<</Type/FontDescriptor/FontName/CAUVDG+EuropeanComputerModern-BoldExtended17pt/FontBBox[0 -19 876 703]/Flags 131104
/Ascent 703
/CapHeight 703
/Descent -19
/ItalicAngle 0
/StemV 131
/XHeight 459
/CharSet(/C/H/S/e/eight/five/k/m/o/one/r/seven/w)/FontFile3 53 0 R>>
endobj
53 0 obj
<</Filter/FlateDecode
/Subtype/Type1C/Length 2376>>stream
x���il���	�L�ĴQ��T�&iK%@!�hӖ�H P��8v�>�{y׻������ĵ��!��@�j=S�P���^Bel��1�V��������O����iPSSs�.���7:w���~�ݻ��l�:����Ѽ+�;���wow��_��r����濲�~,�e׮f������=덹��7���55G�����m�ٛm-^W�m��׸���ٚ�}]�n[S�����6����ӌmw��|>��[��;���6:w:[cm�΀ݹ��x�m׶�k[�-�V�m���I
 �:�N�ހ�pg����  ����f�Y`7p/�x�0��"Pof	X\��Vm^5������}��`*C���'q�Y��@O�	_wؙtxJo����g~zK�&\���>U8+�K���޾KG����#!�i�q9&K�)��q�PW0Ѭ_�
�úY{�9�وc���#D���1*�D�B\Lʘ�I��*�+j�/Sr�5b_��L��ͣH��I)1-f��/�-�Y��t��޴G�3|y;rG˾��y�_]��$7eN���\}��������� 5���z�� �$����Ƨ���9Θ|8�2�"��._����Ӝ�D:��e�XÕcא߳�d'�	iB�֧�O�Ɔ���Dߴ>-�����V��C{t�U񊈆�X�S�~�4hl �ӌDK'�d�=���=c�OXZ��e3�Fk��*e��`Uw1�- �7�y�f��n���j�����y��ԙ�sg
)�e�hȊG���p�Sq�BF����p*��2�P2Z����qɟs+n
e�	k�7���'�����L,<l�}��~������(�WP6�(����K�M1��!W;e�V�o����ۥ׫C���Ч�mˊ�f�����13U�z��x\w�q-����� �����wk������DLJ(�&Ҙ�Q�J��/��3�ʯHi1��p.7H�8h����"+X�=՛��s��p��ƕ ����ט�'�5���0�ǌ�VTk�Tn��G�h��tՅ;��X4��6}+�ܥ��
�d�{��^��e�c3�g�l�tP{9�H`I4�45��&��w�t4�%��xx���co�.���\��36X��:�y~nxR����T�,=ړBUDITZ��P����K�.�L#Yt�{.9GO��ré�B�|�Z꯭o��D>�T<EW:��H	z,��R��ܧ�iZgu^�R�&h�**���ȕ�:ʝ�ϡ�#���J�ԀP[�bR�tQx�S�V�2c�HI$�<�D$!�.P��{S>�c�ȣ��ȱ���	,��E�d w�.ɝ~t���=E�H�����D��RY>m��0�K��7%L�AQC��`�*zy�ح���ՠ���
��D�$�T�ԒR��1�6} :V׃��#B�a�VUIZLo:of�cKC1E��J��N2!6
�~r��q]�<�Y��]�l_�����P4I L����k��[Y?ݛ��h�;.X������{����5���Z����t��C�ڱe{�|X��-�����[�\��l��eaX�W���&M���Q=)G���c̀����+��g�gH�T�t+��y���[��#��_�c�сP�_qh�Ch�QG���vY���\w�/�o�"��u�7ң��,;���]u�w��~g��ݾ#� ᣺�n&�D���
�'s� �� ʢ$J�����qC�_���<s����'M�D46Ŧ����-��jn;.��"��2��u��ZZ�AOg��w'e��P9:�;�� ~�|_�5MU49�e䬔�K|�����d`�}��`cy4?���<���9�(���b��.<!=�8քa�����!�"T�Sɑs�b�/�F2h���^�Pu��M���95W�B���tIM�ZZ)�e�̟���ݪ��eT�DT@�c��#|�@��v�B�,�-`q��:���s8�bZ�.4O�O�s0v���ٟ�Q���YMR�Sd���/_=3i���YT�%�����,�/ă�3ރ�Aj�؋��,��i���]��r��Z��-榹4� �#�1��ԭ��,��B��.��R?���l�(a��V�R/��bC�9妃TA$B �-&�hr?ŝ��I�r�bx�Z�2�.�)XE��x�WY��DJ~�qcp��p�$��i<�T�3nH���Tb�m�&F�a��by��ߋ[o�e���yY/Ս��P<��o�����c�
w�x�t1S̥��"�H�T�{pk�t��T

A9(�|\F(�b��=	V ��\�C�B�*/�P= ��ip
endstream
endobj
20 0 obj
<</Type/FontDescriptor/FontName/GTTECJ+CMMI7/FontBBox[-1 -204 567 694]/Flags 32
/Ascent 694
/CapHeight 694
/Descent -204
/ItalicAngle 0
/StemV 85
/MissingWidth 500
/XHeight 441
/CharSet(/i/j/k/p/q)/FontFile3 54 0 R>>
endobj
54 0 obj
<</Filter/FlateDecode
/Subtype/Type1C/Length 1050>>stream
x�]�{L[u�[
x�M�Ś,���E��!�Cd�%��N�d���V(��Rn�(�EiK{��}�R��.����1!�c���%��ǽ�����01������|���!<��N,~��;��'����nN�~��|�<\?�t<ô=ż�4����}�ur@��褈rY�rmmM%�Juu-�J�UʤjB,�:*)Uz���RA�otRy��i�^_%U�Ui�g+*	���$�}
m�BN4h��T� mU��N�"u�BK�5r�V� H	٫��F�&�9�4"o#��DH1��Iy��ϱ�B�ײȔ�X<�c{��;�P4�q�d����o	9�x�}YX��y�^E���:��`Ɨ��w�EV��Y����9^xLٙ|��E�!q��Ř
���;Hꕃ����@�=t6�%6��ˀf�:��2����I���O����>׮;�jµ���_�~`7��=>\Ȧ����gl�������c�V��[�YS]����Nr/��M������4���:�Kn�؍�����ma|�|��+���'���O��9�2ʯ��r@?��lߙf�&n�\O� �n���᲻�c���ǈ~�1�۳�����usZC�{ՆXv:��b��_�49�`@�n*��y��1��v��^����I'��4�F��Lhr�W_��Q����ʯr'����X����%@��l$eҊ�N����E�c�᳍Q��1�&5�`T��Ng�1��WE����w�f�ŗ��MB������݊e��S��g�_��t��ı�m�8~#�Q�bS��~�	�T��mqݎ��ok�Y�-�c��x̽��o�+E/�w����l.-fs�Џ�]�ۈ��Ƹ���r�\ǆ��t6�J0�����٠�28��:�
����^{0�Tz��q́�%d}+��m*�o �{h_"�3'�K�鏖擉��������U22��!T���ΤW���Z�/��]�����v*ԧغp8ʐ�RN~b��ޓؑ⚔�l�' ȿ�XS
endstream
endobj
32 0 obj
<</Type/FontDescriptor/FontName/WJQWFK+EuropeanComputerModern-ItalicRegular10pt/FontBBox[0 -214 583 694]/Flags 32
/Ascent 694
/CapHeight 694
/Descent -214
/ItalicAngle 0
/StemV 87
/XHeight 455
/CharSet(/a/c/e/i/l/n/o/q/r/s/t/u/y)/FontFile3 55 0 R>>
endobj
55 0 obj
<</Filter/FlateDecode
/Subtype/Type1C/Length 3141>>stream
x��W[�\�];�{(�C�V��,/$���Rr��i0�M���w��mfgw�s�.�|�9߹�ug�j{mǎ����%�y��$$��x���`$��u#^����ьFG�����n�H�飩#G���+k�����חW��ӹ��Sӹ�/�I>�0w�����B&�կ�䓛��W�|����>e>�?��O����S�O�_|^����/������z�ȑw��k�KӹL~zj�|nyq��t>���R~br.��Y��,M,���2�'����~{b6�_y�ĉB��Bq�w3/,-���f�
�K'~~������'-O<iy��=O$M�_��R�疖����Z�tnzn!��f�ԩԟ�����ԷS/��M�q���7R'S�aQ��Gv����ŧ�3�c����/�}���z�מ;u���5��ט�1��X�WqT[劥1�Ԩe`���@�C����*)�T'���[:�6��c�2f���v�C���^w���2��&���	��ZXb��"\e��Z5�
ƺQ8����<I,Se�6����}7����v=L_I�o�ۭ��`ck{�R��1u��b٘�*YA9���Z^�g�3�YeU�[YSeI����x�����<������b������-��PLX���z��c�aɨ��ں\��5E�dCB� Ȅ��aÄ�c�Y�n��`�ߊ�E��y��U�D#!r�0���B�gg���L}9��$?�F�~�c�G��\��wN�$�����������o�zhD��:�c}�o��n������ ��럜����P��h8V�+V�J��gy�������l��Y��A��)�;w.�2��&*U��4�ۺc؆X�C��5~ѽ�����������}�C����������i��8�C�U��ұF�n6�J�-]`��8f�94�Д��i`�4�sl˱[%@�*O�.�}R a�M0٦�{N���9�ףK;��|���eSs]4u�(5��zY�(�jd�0׸�4k�=_�����ҷϜ���:���yq�?y=�.��|��Є��wg�=������
X�[�h�^�t��:���W�JWO�*���q�*כ�Z�\)�M�a4�aꦑ��B�ENi��������]��{����Q���E�91���x���o�U�J�z��a�V�y��p7A�%�H�	����uo�K�����^�ת����[�8���
�r}Q^6jFW��*�lշ\[rl�1�;�7w�+ ���&l�_a�D(�i�f�բTz��Gŗ��4Q�lɬ5;�͂H�N�"��/���Ζ7]���/��	i����~yt��cm;A�0�'����ۘc>NX¥l�[���Rxac}w�r�>0��]	}/�B?v�N[�x��%|g��d+,[�-؍�� YH�+L�y�u7ڽ^�۹���RG��~�a4��4 �b�����I����;}oW�+������@��%m��P�/4g�2.���b+��B�k���m2�%7a8�2�	����j��][�6��:^7��RX�XnK�G�8:{��1J�y�l�j��0m���h 4	L�ޱ�ohK�R�4Ǩ% �g�2��.9��;w���-��%?���"� ����eK+�JU^S�����%6���蕴wſ�^����c�<�|�ͭ�kL���������{�}�u��>l�"�Z�`�(&�
4Kx�E�M��ʼ6�~���cnͭE�n��n��K��E l�&�I��!ԠX'ȐI�ZN])B�N��bQP�{���؅5�X�����w6�^N7��4"����¢*7T�q�q:=����*e�:�tp<������@Zl���d��8�-s��?~�����i�Hԧ������y��7�m�O�Lm9S�D
H�"������=�#8w�H���A0hw\��ۇ�	e�D0R:ȱ��
����������Ɯ2�.��V���;����H�6��OL��c�"�Qc;{K�<��Ļ���8޵\�#�\���Zӛh&��MC*���b6k�fAT�  ( Do�� � ?b��Y��vٮiu8r���4;���ީ��@���o��9Yy]�u�$qv�y?����5C�X�o{���Rq����B21���7QW��/�-����o������R����ܘ� �O�H0�<a�ĖcA�A~m�H��p`K��$2��A��L����\�Ȼ՗@�l���us����k�����w�ݿ�[v��a�� ��D{!G<�@bUyMV�L��x7}���(SF�(5+��0���W�\d�b�z����]���z�n�EW��>i���@-���hO�ZYm���/BZB
�  �a�
�S�>\L;��f/6��,dZ�M�m�\m�6%�S�yg��y�ml��q�A,D/��IT8x�๱j YQ�����3�ĉ���[a��B�2[`.R'I)i��]�r�$��ͮ�|�;X��ƛ�k�Ϻ���G�6�ю:��~�o�{��$@!�<Ru�"d6Y�UUW�����"�ʤlU\Y(�+����hL@���'�O���ھ<x/10b	ڂA*���軣Ҙe=0����]����7n�o�d�,4Wud��4���Qf*'W�������6K�$�g�wϹ�
�S��/�{����n�mG]�u�Dڛ�L���0������լ\��@�&�b���^�?�<�ܭ1?��ߋz�N/��]�/k��`����Y�B)��8ݘ���9:g��d����>V��
.��^i���۱����[#��Ϗ�62�)�ak��WY���m���\Or��nw��3xK�#/���-N�3�6I�	q�]��ZA+���K�JՍ:���uV�
��j�Z�D�!�����޿ӿe�܃
DLB����@:�/�+ʪ�Z.B���뉰9,�¦�Ҳ�9(3�Cxw��ї���N���d�l`�D
�[�[K�)�Jae��槯�58�	-$�15��H��[z߉���q�(�����{zV�9+�LMbi�ߎ.��x��>u��#s8\�p�%�� �vwK�'�8iؤE�9(1a��RpE�@a+FI/�e]�U�aL%xJ!����t�ϒ �Mw[7�%����7���"�Q�!��>�H�$��o�m
endstream
endobj
30 0 obj
<</Type/FontDescriptor/FontName/YUIWZA+CMEX10/FontBBox[0 -1770 1387 50]/Flags 4
/Ascent 50
/CapHeight 50
/Descent -1770
/ItalicAngle 0
/StemV 208
/MissingWidth 500
/CharSet(/parenleftbig/parenleftbt/parenlefttp/parenrightbig/parenrightbt/parenrighttp/summationdisplay)/FontFile3 56 0 R>>
endobj
56 0 obj
<</Filter/FlateDecode
/Subtype/Type1C/Length 952>>stream
x�U�mL[e��C߮Xйt�k��VGB�	��B����3-�@cK�����2Jii��/e����d�3Mf6g�f4J�M�^b�>,31��s�s��F������������0�<�b�����|Eڕ���)�t��p��������s���&��^z��'��104u��7?ޫ��C���U�w7����{K����+�^At79��z��*x�x���&� ��ݯ�J��jϞ���2�7P�[����n��WbPp�o��$�m�W��L��]5>��CD����6�C�V=H���SZ�����\�u�[�U�[���6�;��8BØ*������H��H�d��j�c���u��ɝ��y��xa�omm����Q<��)��\���=��(R��jtvO�I9�lw�	H|��z��G�I%�3g�7��0���*z��E�|:
A`�;�гS���4e;���b�L}���~аlx&&S�JY3i܌�El�"��o~�0������㥕�Zl9;�T��}�..)=#Y�H�� tui�u0N7S��6�":�*�٬2qO����Y�)�7����*�j	B�>�TDB�����:ڋ��9��2����'���1�k4k��)Η�kr.ƎG��Z���hh���4p�m�R�ш���t�׵��Wzؿ� '�Ch�-�'��`��w�{��h�AZ4 t�mĭt�ة�ק�͌mC���:�V�e�!b#݊��g�66���♸��{�U_�W>)��2���j/(���h��wDFC7�?c}��X`9����_!�~I�,�������Zj�c%����FeX�}d4���bm����ڜ�T�|e���aO6q=������N\�b猴 /8�4J �����O��Ik�:��>1����0m-�1j�Θ.�_~ښ���O}1b6k��a�c���
endstream
endobj
41 0 obj
<</Type/FontDescriptor/FontName/CNTUYP+CMSY7/FontBBox[0 0 299 559]/Flags 4
/Ascent 559
/CapHeight 559
/Descent 0
/ItalicAngle 0
/StemV 44
/MissingWidth 500
/CharSet(/prime)/FontFile3 57 0 R>>
endobj
57 0 obj
<</Filter/FlateDecode
/Subtype/Type1C/Length 295>>stream
x�cd`ab`ddds��4�T~H3��a�!����}��ì�<��<,�/�� �=��{� #c^qS�s~AeQfzF��F��������������cnjQfrb��obIFjnb	�������ZR��a�QRR`��_^^���[��_�n���P�Y���Z�ZT������W������ v��t��-(-I-R��OI-�+(��Me```4``�b`bdd�������?
�3�����}ۏ��sz&wO�X��8'�>��M��׮����.��U��'��Κ$�W����������p���3���y �i�
endstream
endobj
22 0 obj
<</Type/FontDescriptor/FontName/FLBTBY+CMR10/FontBBox[0 -250 721 750]/Flags 65568
/Ascent 750
/CapHeight 750
/Descent -250
/ItalicAngle 0
/StemV 108
/MissingWidth 500
/CharSet(/eight/equal/five/four/nine/one/parenleft/parenright/plus/seven/six/three/two/zero)/FontFile3 58 0 R>>
endobj
58 0 obj
<</Filter/FlateDecode
/Subtype/Type1C/Length 1798>>stream
x�M�{P�W�!$��B�-��_ҵ[�U�Q��(�*����� �`��8C(��%b�������ֺ�եb��¶V�z~x�c�tf��ܹw��s��s��
({;J ���wxyN���	��vܟ�@Lʉ�"p����ŒP�s�'�x%�R%��5q�*��=j�����w�����O�Vj�"����Z�R��7����8�V/w_��jS֬\���<"թɚ�w�-���*�e�RsH-ߘ����Vʧ�󘞃��)iZ�F���$Q����j���������y{E�Rn�j!�R��ٔ�L�PRj>�P��x��=UIM������u��{���_�����Ł�ё3�����<4�iu�~��#[��J'��gZ$X���/�t�Yج(Olɲ�^��@��V��da�A��1#��O(���'�#BV:�	bv��h�C�3�@=PP��A8F?l}���<��c1��B�ɈU�(
�@O����z �br)��Le5�BM����k�i�8�YŦ�ʯk�+�B�%6d�#��x/�(���t.��?玲%p�t�HYs�=7�����_�^s����h�\��E_N�(>/:�W���޻�+hGtX���d1��p	n�#�W=��	�З�w�c�r:4�Z�b{ҪP���=�<��ѡ��s�n6�)���Nzi$�N�O����v��
�1t�����t%�#���ק�o�h�KN�w�	�d�b{�G��R؞#'l�ui���ћ���:�bL�飅H��޹W��=���4q��2�g�/�����k4��.�	
H�Z�}p����㳾35��<��5�W'�m�:�M�q�.�D�N��� d��lN�l��8;t�F��q��c�v�$K6��8k�V�ȹSӫP���kB|L�0AiFqF���0��:�L��DW�
r�6��nb�C������D4@�~�r��2S����L>v7�xh��;Q�N�n�]PTT`��F�������y��#.��@1邲��O�A�u�"�U�Ӽ��Mx�ϛ��Sȭ�[ŵh'��&��F�ҳY�F�$�(F~'Άt�k��j�p���#CBn?�c`�pP��b̯>B �������a-l(���?��n�-�l�m���C�Mb�=&>���0��&�>�߈s�WZ�n�ݏ��?l��ɰ5k�u���a��	�|'�މ�L�j��>� t��̇�t�����s�؄D�i����8m�sXbK�x�:dS����o6��q��X]�J0��@Od���{G"
X������]���Uy�Pbd�o�w\z����{�����$�`�[��@:�I�'0P���#r���އ�8qi|�g�v��h��s\;���UJ(<��̣Ϯ}�z�s�7�C��-�'mf�ɾ}���.ܮi��r�WN���2uX�QS�W�Z�y%�%�KK'�
h`{ď:6-#�7&E���p]%;]h���=Ŝ�������(@����,�m{��i0.�q�<��<a�cޖ��C��.�%��Ǘ�5��$���]��m)Ƴ/�<l��<�LƉ%h�1�(F#7K4�Kv��6����f���L��G�`p��3B���TŲ�Kb.h�o�m����r��%��.����m�(PT�k�3�y�˔�=��V����ت�����XG��1�Ѱ�����F�F�T@ ��2㺩�TRt[���%����W���&�ˤ/�~>�R�c��j���r�����fߙ�ζ�5;̲T:8�1;̥��%��
endstream
endobj
16 0 obj
<</Type/FontDescriptor/FontName/ZAMMNU+EuropeanComputerModern-RomanRegular10pt/FontBBox[-40 -245 1009 750]/Flags 6
/Ascent 750
/CapHeight 712
/Descent -245
/ItalicAngle 0
/StemV 105
/XHeight 458
/CharSet(/A/E/F/I/J/M/N/O/P/S/T/W/a/b/c/colon/comma/d/dollar/e/eight/f/fi/five/four/g/h/i/j/k/l/m/n/nine/o/one/p/parenleft/parenright/percent/period/q/quotedblleft/quotedblright/quoteright/r/s/semicolon/seven/six/t/three/two/u/v/w/x/y/z/zero)/FontFile3 59 0 R>>
endobj
59 0 obj
<</Filter/FlateDecode
/Subtype/Type1C/Length 9947>>stream
x��{	�\WyfyQ�gb�������f�a����F�eɶ,k�}��ꮽ޾������^�Ջ��F,�r�'�0��0�IBX^+�L�j	9��L�#霮W��{�����=�����y睷��d">ѷw����Dr�/�-~�/1���������{�\=1]{����[����w\��-�+w��.� \|!��#�7�����ׇ�b�w�.�rs�x_b�t߁-���ؖm}�{o��Oo�74=�wb˾얱�����}[����~`�����'��*�N_�������+�G������Ư:{�U[έw˹o�X�Ί��]�hͿ��X,��ό�'&oL�45��%ukzof_v��܁;���k`p���{FF��{�G?���>�����}o���}�ʫ��е�H,��؝��b��m�]�;���=�{c;b�������gc�b7���q����cW�n�]�9vM�s�[b��>�-�����m�;b��co���zc�����,�CcC��b����.��>��؛bo��%�{k�z�����{�|ꂇ.�Ԧ�mz���^���v�W^7�{���K�߼���y������M�7��2�}U��o��6�{�7^��e��憎S{珶,���������.����mݺ������?\����}�r��W^y�%W�W_s���w]{��3��r��� �	/����]F�TI�S9��y�3DS2DC6��]5�^�[v[h��}�}�}F�M�y��Z��9�h4ix�Ƭ���)95�>V�lu��{���@�.�����9��y\dzh��}I���{�<�g�^2�/��,��22���DwxA�[���]��oڼ����g�ff@K)%-Z�{@� ��"���	�fZ�$L,�el,p��7��UJ�tΦ=P��[��ƌ�*/�6ǳ}�d��2��%[�	�.�!�_0�j���8����! ���|t��6�/�{����@R�x�*�.��!k�\�G�pV�5|��c����2FF����4��`Ix�O�?�ټ.�����	i�M�Y&O�Oߜh_���A�>5���f�9z�j	KjK]r��V�T�r%�����a<�������A�N8ڄ����_ҿ86�`yD�W�m�����+�Q�c.�v����/��Hk�	D9����i�aY�i:�k�F`zQAa�:!��T?n�r`�g�v�5�b�􄒔Q|��WF�Ѣ�`�BQ�5��C;���2]��%�h<�:���������^N��#�P�_`B�LP�&)�D�G����y������~gڜҦ�����O����Jb�q���2��*�,�W�HU������fgWʫ*������V�w��AF��
�D������p�V��Lܓ+�,�(�`]�1��_�]JϏVzw,�L쌓��,WNx��2���J�{��R��W���Q򈺢.��w=������wۊl�qf���7� z<lP1!�h|zd(�_�e������q��ψ3�)�t���C���̧��|
��JC$_�	����^����	��cp��\J	)%���g����4���s�� �'��=�n���`���
���cmٗ]��TA��!]-��,�-���d���nL�)t>�Mv�)0I%%^�x^�y�&��(@'����t��\VJ��x���%%P�y�+]'�)p|��L�bl�$<��At�+� �\����l������UI���r�Z��2a���쩠5������@�A�P�I�Px���39[jpM׮��مd�sRZF���1�\��i�w�61������z S
*咮׋F��"s0
+�bބQ08=Z�DQ�>�i0I'EN�b #�	��p�D���.���|.
E�yeN�ς�O�6jp0������kB�οY�.E���Q��ZSjz՜qA��|�<�x���v�͉Ҙ=��#>�p�+̼dB�6C1U�_\,-���c���Y��؄A�XTr���N9��h���v!�(My&�y���Ȫ�J���� I2*Ȣ(H�|
N������/�1c��131�H�*��V�(�6i��䪹>��2��_Kb�[ 槭1̠֟2#1"��r.�¦�)9+�Ԝ9$VxO�O�%[�P�dF�E��y�T@t�*��sJ�&I
�MU�+��)���fY�iZ�zí��n@��&��ӷ�Ǹ�X�����+<���e��@٪X��-��N��w�1i8?���3,I���#s
x�W�Qdjl]n��$	߳�~O����UR5!
�(@��H�]�����3&k�kq�efY���Y��U�A�t�p�k{�˽M����& eP���#��䦨���R�&�,��,�a������E�α0�<��33K�'r U@%��� �����X<�i��&hvJ/������^�Y�1��0XzI%��?k? �,��H
�!�3>(PB�	_B��@��:��z�6�����+���Z�1���5*�G���[9+o�^i���ܡ�:a���Q)�d�������r��'���V��\�̒ZT�� � FPp��A�&�d
e�.HY	�q�H��sc���'^�x����p�ਫ਼>��3I{Sg�n̲y�?�9�E��,�%�,:����G�B�p��}�A�`(�ba���`~�7� ҧ<S�
��{���,NU!�I���U�z�֬�I,,D�i�BB&M�!<�7�o�^x	m4��m�T�'�p�1��x�ik��EDg�Uتl����q�rS)�=���������]:��ի�dXy�����n���W���ǂc���_����nX�p��E�j��Ex���jO��ixs����z�o�7"pS�����8�-�S�
��@dw��Ҿ�?��l��p�^�s���A���o����s3��>K\�q�8�(�L�`��d�����wC�����p�h*�}�Tg#y͹H�a����}7p����s�*��q�,�J`�A�A�!|�����ё�����Z��8l������L�-��i��I+Uɛ���"jI�.JAy��T��<zlr0���,V�s��@�E��G�#���S��9n�0���9���]d�� S��46n�B6T�X�����v�.T]����)�n�&Lh|NEÁ�{�o@@VɊY!�f���h_�>��3���>�Ԭ�[�J��5����֩�J'w����t�����[z\���D}@�<gh�$(|�o��3i&%��!����st��.XtI/;Eӵ]�i�i,lR�^�P}XaD�fr��_�����}5	r��,ң|ڣ}�>>���1TEN�yc�9�T�����d'�[�e�)�"t��&A�B�(y���٩;��Y�m͵튵��-v�չlyj�S�u0�T�"�d��2,�a���<��\#ќn����2N�O��>��oKa�o��gG�C�v??&��S��!:��%=�N���Kݞ�˞�8�z����Ԧ�i%2P)i��(G�Cq,{֣��s�����`9�H;��{L�5|�(9�4�k�	f!���b��{��}�­&�Y1�+��<W�����d��!����V�65�7tx4Z��aF���J�)��D=3C�ߋ��8ʪ�Xo���%����z�%��NK��R��d���kA��_�O�vB�������
A� ����̢R��}W��vG ��$�F�9z�d�e����pWe�:�L�S�4�"3�L!�����?��s�� ]��
��_^|��X�r�����
U��N9�N@��I��DE�!ȇ��Dj�!B& "vWi�q
��
/y���m��A����REh�5�J���u�N��
��!�}�9%��%A��H�AI:�'����|_�K-
�G5Y���yA�`ؘ�:�hx����M���ӥ��^���h��E�*�f�<^^~u�����s���^�mC�q!\���A�����X�U?o����`ϩ�W��ųj��j��(� c�{��.Z�j�/P|��������Zzgjg���m��z{�W���1�+�p���`r��n��R���҂n�n��aZzŭ�u��֡C���=�~rt/4�4G��4�[��x�I�5(����U	��NJJ�|R(�d�r<,A����~��v����'�O�0OL�װ��sy�R%���4��ᩳrjQ)gmZ�BV�dh������LUƝq�O=@e�d���<K�|ָ�ћN|��=�)�:�7���rkO�5҂i���"��u�"�*+`]���R��
�	Hf�A�y�9�N�Qe����0����� �>�+<�6Ŧ4�YCi����-BM˶,��(mH�Q������X�Wy����DZ�b2�� t�3�MJ��6;�t ��<��:��&�Ο �o@�o?|��χ}�g{������zu�,�#\�W�T� �2�A����T�SQ���t��Z3�U��b�E�h����ʳr�0E�� �B6�X�8��3���_|�8�sX��ԦX
6�-�0�w��]���Uņ&вlG*C��=��ɀ�>�j�������ܞ�r�z��73�4Y)��=K�s���++O8�]�KpG��s6���{$�#y���٩D&N���W0�p�4H��h�Y��q�48��d��Mti�Z�<4��RD��-vo�.cS5;�������֑3�t�P��Q,�IL�2�d~��7�����Z|&1�Z�^ή�G���q�z�?RG�J��ٙfm���J�V*��5�%���L�6>3R����	5&����+�w.�4�ݾl��>=|���n��z��qX	���|~������P��Յ?Yy���^5���3�����v[�چ B���x���Ĺ�������4(䬶Ѡ�].A�+����k�}��!`�DD4����/"NᤜǗ�]M1���4昪��O�j <Χ�� c�mH��v�����٨�0u�V����;��Ӌȵ�e�F�������->� �
�Ѱr�@��������bd��sښ��*3A�\�{E�d���Е]�ٽ_ܵ4R���utP�zu����`T!�9.�-�v��*�G�CY[�y|Ը�
VNϢT�8�����6�%�*�������p�1�@�!��|z��v=��m���>���dI'F�@i��<�#:��g�c� 4��j�A��KxT@��%��d����r�:\>Z9~�~\���/��OY�"L`M�Dj}�ء�]�]{���S��V�,�Z�����/��U�Tp����*Q[ć�y�^+TK^ɭZe��V�%��Q4I�Ζ5��:P��CWm����.g0з�qm��.@%�2,�F��5}9]u�j���<T��i~�q��pZb�Aa�^hQU�)�QyI��U�\��Y��!z�O?�=��J3 "�����W&mt#��'�ҙ�D?>����є���eڥ}�H��-V};��)-��uP�tItA�U#�F�i� [�1Df#���8�wZ���4��=hu	H��N�=����<h ZL��3���X~��d)���÷��c��^r��nVfEN�)
V�<zp�e@K��z�P�(��Q�X�����A��2�s}���;h6p�G?_���7X_)�{	F��/t��^�V3��#¬4�̘�b������ܳ��|��QU������4kg��qW�'n���R:�U�FnY<R\�����r5hXu��4�9i�i��l�<�:Y+m���E�Xw�^S��f�E��Z�x����M
�mr� �Gr�O�2�p7���5��W(t��&&I���α9>�'�I=�ܿ����2Q�kl��e��S�kB���j�bڢJ'ML+(+��0����xj��`���m�7?�x�N�r��/C薍�Jω��8	S�u�$��F��hٲ-Y�a�e��V:���i���y<���VA�@���H�bZ�Ǔ)^�D^$^�崘�2f���	݂g犐��TmD�OE�=jʼ�EC��T�ФW�c`�X��~������5 zY� ��L�W�\םi����Zj�j���l���3=��0���;JM�Q�6�!�<���_��_d)Hu91/���Q/���٨������WsPt�%�����/hʎg9��(5�&נ�n�Ώ����x�M�#��:����]�N�{n�����|���pyrKi���_����eTFޫ������EA�$N`'�C^=7cz�����"Q�{�����Z�Z��z��[s��U���"�z��M�C�S��W��JE�HTg�d|���nܴ���d���F�#�����6��q����#�<L�?�=%��]W���;[j@�oC��%��Z�X���������*~-�G�wDD�J��:^�D��4$�q4�$��B����!���U3Մ;����B�H��S�gȍ��T;�� V�ڴ_0RF�ueϏ��y�}��@L��^�fX���މ�ҞG÷�|}�덯�����h_��iѽt�&(�f]�4;�0D�3���'�׭�J5�My�}l���gm1��� ��ƨ�c�\~���ϵ��i��_�����"S�K���V��6��3�wn�T�5r��&�i3
RA�2Y>7���kڋ�0��9�LF��~�d����h��� �����`f�.U�QY�uM(�՞�T�r�PpL;�@w�ո���y-�VA� ,j�� eGgG��
(:E���;�C$�/_���ӟ��Yyb���z'�dW��/�呜�^"�d�������T�ޑ��dk������q��{n} s7�]���T�F��������g
��c����C��K��/��p��/�N"�/�h�<�A��Jy�İ|�L�)4���0[��H�'�	7�ƕ	%��ة�3�'j�2�\��)�2JH{�w���2�)5��8��������F-H�{g>�=��qXM����فm9��x�r+����|S~��=���Xvt�g�?����F&4LOV��Q�4C3U��t]Wu�(*d�5DY������4J�R��w{fWmׂ٫CK�8h�ڮ �
9%��*��oub�-��n	��$'F�<�c3.b2&�	��L|wOxa��7\���by�^��Q���:?��ܾ�V�U�Y��h�aiz
�g2de����{7�^Mm��(�b��3��Qw�2�ZI���9�=Tn73~�Ǫ���+ZRz6���^j���_��±me@0@5B�e\����tvb23�E?}Ww��OV�
�z74�K �H��eo����E�a�e<>!zà�jK�bev��4�Z��e����nh�&�Iq}_bOn|zr�0M����*i�%\C� �z�k�.ZY���j�`�e
�Ύ/�LE�HU���7�?�ҡ���|�:oZ`IZ�V�U�+�g�ŋ/�ܷp��3>���S����{�{����2��$I��"=�[���\U+f�*��b��՝ھ$|�ۅz����A&�:���Iߟ�?<�[�eL�0�M$[��� /��"�$�J��襟轟� &k��Fv�m���td�[�F�Eه���w#��$RLpSD*��
9"��v�Ƕ5FZ��B�iu8����S��7��.1E�\�m膡�����/��')Q�B��ȑ)}J��ƫ\i硽O����0+�-?�����Zè�U���A婯k���˩居�R��i�HY�CX�3�	�0p�ؕ���$��$J#��b~΍z)���5k��g��lJ�l�x��J҉�y�J�c�����"R��:f&�t�Ey)xDK]+-�e�X�AŭE[S]]i���@�E��1e�X8�׽m�>&G�1'�T��R�$4����ɟ^�rrV����h6��$���1*���Y�����q��R��B�o��LD�Y� �n� ��O��xu� [��wQ��¯���]��T�}2�e�?g6��}s��Ӿ��ݾ��ꅧ{����T�N��mM�l&��r�	O�����-����W3[4eUV%U(�ňЧ�׃�|:0~?� �v�g0w�p���\�	���EZ�tUJ0���,3L�����|G����?�=�۪�[z��XVk'�g�/�B��pe��<���yp�2�q�y8IcZ�6�w$�`��aa��la%�8�\��5Rk���ʊ��]�u�(�:��8�����#���	�����nz��C�[Ab��'w?c�З�j��G�G�	p�=�_�y�!e��eԘ�?\b�S��L��`zCK`"�3*�KK�߭�OwC�Em�_�-90�ܒ��v��hvz
$����|��WN���1��L�0`>�P�@W ����ێ�Q�5�Qr �1���~�w�^�y�L>*A�(�fhz``l��C��H�}��~��G�O/�0���O���^���M55��t�'=�������WG�����C㟫?x���ڜ[�KLך��4�5������F7ޛuZlܣ\��}�;�-���¿��"{����x>�IP!�q,#2h�a��J�&Bc�����k;��:�tl���B�^ʆo^)|;�����t�S8�$(�x�191���l;[;��f��ݡ����>�4J�u�f����P�	nP�Zt�.FF�7m�>�W��7f���g���a<P�8�pi_Nm��o����3;����Z��W�
�
��&�C-�&U<��;�2�r�Tk��ni7�79�O��Ibġ���s��9�F�����#�%�|�;+g���G2��5��crA�^T�t�A\������4�&��j=�����zM�B���۫3�k�óO���g�S�� /��a�0�F�a��F��g��>�}L?�l{y+�g�	�=������^�ayL�ǅ��s١��"�yoU�⳹%�ė�2wP\��ģ �@zDYR[�V3�N�������]�ǍW��E���̒���=���gH�""&AM�$Φ�{7���׼4)'4L-��G�r��� �� �yH�*�� C��=Y�	��In��.fgTa�߭����_�T���U���1i%S�}�������;Fv�?����߽kǝ��
&#0�t�Zo�4�%fDx"$o�eY��08y�[�۔[A�9���������9�k>��=2��=sۍ�6.M�7O︍�A.���$V���\�������ֿ�]�VJM�lU��ZTKJQt$G�K0���1(��A��N��$
w��J�'���SL�dP� ��gCQS��3��.Q������3ZF�^b$A��/3����\�J�� ٦����ь�1s�t����p5�L�05˄�,t��2�	/v���"�b���ڸ�����2��9ꋙgē���<]��꫁샢��W�2UD����}������U�*~�\*5�n���ZU��E�>:�4XC�\�^�c| 7:N����u¡k�eP�7��t�����^����Z�P&�(h8E��M�I?��g3��\�E��T8�J[�+�咼�̃�����]`Q9(/B�\�L��1�c�b���g���w����^�4�[����]m	�޻	.������W1С0�j��l�Y�Z;�a�	��H�)����f��^���"^�|���;�����K�5�p����v�
�i;��4���;�$��,�@���I�d����W
��nF\*۔��+V�	.R҃���Š��u:zC���H2@�x.�Ev!�?D�'�JFa��e�-S�{L�q\ǳzgJ� ]�l�Kds�/(�!�������8�gwL����V�5�n���ܟ
endstream
endobj
43 0 obj
<</Type/FontDescriptor/FontName/VSFKWG+EuropeanComputerModern-BoldExtended10pt/FontBBox[0 -201 616 694]/Flags 32
/Ascent 694
/CapHeight 694
/Descent -201
/ItalicAngle 0
/StemV 92
/XHeight 461
/CharSet(/g/i/l/n/o/p/r)/FontFile3 60 0 R>>
endobj
60 0 obj
<</Filter/FlateDecode
/Subtype/Type1C/Length 1350>>stream
x��S�oSu?��(�4!���	x��bx��"a:�&"J(k�ƺ��v]O{��9�w�=��+�6�[�h�	
0!���������������|0!���y����ܾ.ds�r�^>��E�_���P4��z"�@,���H�$�����7�������֞�����W���[��M`�f�g�ŝ͹g���M}���:E��1_"��c�!oO �;	'��C���܈w(������]���O$����S�TW:~�
u�Cݹ~_8w?��n��n��3��{7({ۜ�4� �;�����#���9��@z�1�@f\�;^븱�ز}����]K�=��E�@0y��(� 9�G{�+���n ���|͝< ׷�����A7���:U�Wj��BmQ�)5��Y��)��� ��Oxt�+�j�kN�tVctZ��DeX��q%�l��OG0�%2�߻;[��Z�{z���3g�>Ĭ������?ҏ�}�������5��������q�����X���Y��k;4Z��aL��1ІCRH�Qz8�DY�f�b���,��Ĭ��0W�PiH��J���Kl]�D�i��5���7��i�jh�jB����:�.�k��]4��Ii`RXatu���qO��s��jN�U��^��x�z��G��g�S��S}�~�����9�1*G�?��;}����◈F�xN��yD�Iy'ғ����)�r$�.��a�4\Gq���2[��`��}�*�b���e�ɱYsFF;[C��_��ֵ�{�����npG��~�n�.ϔl�$e�fi�f11�f��̜mC�0
PSIGe�.h��k��i�m�Y6Ȇ�!"K����Zk�<�!sd������:f�<A&�L�i��xF�E�"#�zp&��AoE~f����9�my�a^SJbI(	E�fl�dM�8{�]넌�o�rk�ŴLH�D�i�
Bщ��+L��f.�`^�Wgus�46����W��I���ݭ������AA^�#͑'U�rV%8f
*�q�SS��h�|�
��Y$ �*A�/�S����I��)��	�@�(sr^� ��t)[΢����y��&�RRD����s���9��$O
�B�H=S�
�\e��k*�]1S6%���;������u8��8_!�	�d!+32+s"2t6�K�/��l}�hƍT)k�%�*�@kC^Ԡ
5秘�)[NϚ���?���#���`!mP�Z�5R�L�-��M�-� [��-L��R�(kQ�9I�t�"D���v4d{d��8�ѿU}f��O?�jOk���}m��n�H��J!q������;�o߸���ܝ��f
endstream
endobj
10 0 obj
<</#23auto-1 [4 0 R /XYZ 0 657 null]>>endobj
69 0 obj
<</Type/Metadata
/Subtype/XML/Length 1316>>stream
<?xpacket begin='﻿' id='W5M0MpCehiHzreSzNTczkc9d'?>
<?adobe-xap-filters esc="CRLF"?>
<x:xmpmeta xmlns:x='adobe:ns:meta/' x:xmptk='XMP toolkit 2.9.1-13, framework 1.6'>
<rdf:RDF xmlns:rdf='http://www.w3.org/1999/02/22-rdf-syntax-ns#' xmlns:iX='http://ns.adobe.com/iX/1.0/'>
<rdf:Description rdf:about='1c7dc82e-dfae-11ed-0000-acdffcb91873' xmlns:pdf='http://ns.adobe.com/pdf/1.3/' pdf:Producer='GPL Ghostscript 8.71'/>
<rdf:Description rdf:about='1c7dc82e-dfae-11ed-0000-acdffcb91873' xmlns:xmp='http://ns.adobe.com/xap/1.0/'><xmp:ModifyDate>2013-04-17T15:04:00-04:00</xmp:ModifyDate>
<xmp:CreateDate>2013-04-17T15:04:00-04:00</xmp:CreateDate>
<xmp:CreatorTool>TeXmacs-1.0.7.19</xmp:CreatorTool></rdf:Description>
<rdf:Description rdf:about='1c7dc82e-dfae-11ed-0000-acdffcb91873' xmlns:xapMM='http://ns.adobe.com/xap/1.0/mm/' xapMM:DocumentID='1c7dc82e-dfae-11ed-0000-acdffcb91873'/>
<rdf:Description rdf:about='1c7dc82e-dfae-11ed-0000-acdffcb91873' xmlns:dc='http://purl.org/dc/elements/1.1/' dc:format='application/pdf'><dc:title><rdf:Alt><rdf:li xml:lang='x-default'>hw8.pdf</rdf:li></rdf:Alt></dc:title></rdf:Description>
</rdf:RDF>
</x:xmpmeta>
                                                                        
                                                                        
<?xpacket end='w'?>
endstream
endobj
2 0 obj
<</Producer(GPL Ghostscript 8.71)
/CreationDate(D:20130417150400-04'00')
/ModDate(D:20130417150400-04'00')
/Creator(TeXmacs-1.0.7.19)
/Title(hw8.pdf)>>endobj
xref
0 70
0000000000 65535 f 
0000009813 00000 n 
0000054207 00000 n 
0000009747 00000 n 
0000009425 00000 n 
0000000015 00000 n 
0000005181 00000 n 
0000009892 00000 n 
0000012524 00000 n 
0000028864 00000 n 
0000052760 00000 n 
0000010989 00000 n 
0000020823 00000 n 
0000011354 00000 n 
0000024226 00000 n 
0000014808 00000 n 
0000040568 00000 n 
0000010627 00000 n 
0000019609 00000 n 
0000012875 00000 n 
0000031604 00000 n 
0000014586 00000 n 
0000038390 00000 n 
0000011878 00000 n 
0000027142 00000 n 
0000010297 00000 n 
0000015671 00000 n 
0000012239 00000 n 
0000028067 00000 n 
0000013571 00000 n 
0000036463 00000 n 
0000013055 00000 n 
0000032972 00000 n 
0000009933 00000 n 
0000009963 00000 n 
0000009585 00000 n 
0000005201 00000 n 
0000009404 00000 n 
0000011687 00000 n 
0000025806 00000 n 
0000014337 00000 n 
0000037803 00000 n 
0000015447 00000 n 
0000051073 00000 n 
0000010114 00000 n 
0000010144 00000 n 
0000015941 00000 n 
0000019851 00000 n 
0000021117 00000 n 
0000024485 00000 n 
0000026051 00000 n 
0000027394 00000 n 
0000028314 00000 n 
0000029143 00000 n 
0000031837 00000 n 
0000033237 00000 n 
0000036767 00000 n 
0000038011 00000 n 
0000038685 00000 n 
0000041041 00000 n 
0000051325 00000 n 
0000010902 00000 n 
0000012112 00000 n 
0000012403 00000 n 
0000013317 00000 n 
0000013922 00000 n 
0000014105 00000 n 
0000014499 00000 n 
0000015319 00000 n 
0000052814 00000 n 
trailer
<< /Size 70 /Root 1 0 R /Info 2 0 R
/ID [<CE86651600FFDE196B74CE3B1ADAC580><CE86651600FFDE196B74CE3B1ADAC580>]
>>
startxref
54373
%%EOF
                                                                                                                                                                                                                                                                                                                                                                                                         ./hw8.tm                                                                                            0000600 0112121 0112333 00000021223 12133526206 012476  0                                                                                                    ustar   silao_xu                        silao_xu                                                                                                                                                                                                               <TeXmacs|1.0.7.19>

<style|generic>

<\body>
  <doc-data|<doc-title|CS157 Homework 8>|<doc-author|<author-data|<author-name|Silao_xu
  and Tc28>>>>

  <subsection|Problem 1>

  Many industries have to solve some version of the following ``hiring
  problem.'' Suppose you run a business that needs 8000 hours of labor in
  May, 9000 hours in June, 7000 in July, 10,000 in August, 9000 in September,
  and and 11,000 in October. Also, suppose that currently, as May starts, you
  have 60 experienced employees working for you. Each month, each experienced
  employee can either work up to 150 hours for in that month or work up to 50
  hours that month while also training one new hire who will then be ready to
  work the following month (and will be called an ``experienced'' worker the
  following month). At the end of each month, 10% of your experienced
  employees quit. It costs $3400 a month to employ an experienced worker, and
  $1800 a month for each trainee.

  <\enumerate-numeric>
    <item>(10 points) Write a linear program that represents this problem,
    and describe what corresponds to what, and why it accurately represents
    the problem. (Note, do not worry about integrality of the solution; the
    optimum of the linear program may include things that mean, for example,
    ``hire 27.3 people in June''.)

    The variables we define are as follows:

    <\eqnarray*>
      <tformat|<table|<row|<cell|w<rsub|i>>|<cell|=>|<cell|<text|number of
      workers for month <math|i>>>>|<row|<cell|
      t<rsub|i>>|<cell|=>|<cell|<text|number of experienced workers
      participate in the training for month
      <math|i>>>>|<row|<cell|c<rsub|i>>|<cell|=>|<cell|<text|the cost for
      employing in month <math|i>>>>>>
    </eqnarray*>

    The constraints are as follows:

    <\eqnarray*>
      <tformat|<table|<row|<cell|150\<cdot\><around*|(|w<rsub|<text|<em|May>>>-t<rsub|<text|<em|May>>>|)>+50\<cdot\>t<rsub|<text|<em|May>>>>|<cell|\<geqslant\>>|<cell|8000<htab|5mm><around*|(|1|)>>>|<row|<cell|150\<cdot\><around*|(|w<rsub|<text|<em|Jun>>>-t<rsub|<text|<em|Jun>>><rsub|>|)>+50\<cdot\>t<rsub|<text|<em|Jun>>>>|<cell|\<geqslant\>>|<cell|9000<htab|5mm><around*|(|2|)>>>|<row|<cell|150\<cdot\><around*|(|w<rsub|<text|<em|Jul>>>-t<rsub|<text|<em|Jul>>><rsub|>|)>+50\<cdot\>t<rsub|<text|<em|Jul>>>>|<cell|\<geqslant\>>|<cell|7000<htab|5mm><around*|(|3|)>>>|<row|<cell|150\<cdot\><around*|(|w<rsub|<text|<em|Aug>>>-t<rsub|<text|<em|Aug>>><rsub|>|)>+50\<cdot\>t<rsub|<text|<em|Aug>>>>|<cell|\<geqslant\>>|<cell|10000<htab|5mm><around*|(|4|)>>>|<row|<cell|150\<cdot\><around*|(|w<rsub|<text|<em|Sep>>>-t<rsub|<text|<em|Sep>>><rsub|>|)>+50\<cdot\>t<rsub|<text|<em|Sep>>>>|<cell|\<geqslant\>>|<cell|9000<htab|5mm><around*|(|5|)>>>|<row|<cell|150\<cdot\><around*|(|w<rsub|<text|<em|Oct>>>-t<rsub|<text|<em|Oct>>><rsub|>|)>+50\<cdot\>t<rsub|<text|<em|Oct>>>>|<cell|\<geqslant\>>|<cell|11000<htab|5mm><around*|(|6|)>>>|<row|<cell|w<rsub|<text|<em|May>>>>|<cell|=>|<cell|60<htab|5mm><around*|(|7|)>>>|<row|<cell|w<rsub|<text|<em|Jun>>>>|<cell|=>|<cell|0.9\<cdot\>w<rsub|<text|<em|May>>>+t<rsub|<text|<em|May>>><htab|5mm><around*|(|8|)>>>|<row|<cell|w<rsub|<text|<em|Jul>>>>|<cell|=>|<cell|0.9\<cdot\>w<rsub|<text|<em|Jun>>>+t<rsub|<text|<em|Jun>>><htab|5mm><around*|(|9|)>>>|<row|<cell|w<rsub|<text|<em|Aug>>>>|<cell|=>|<cell|0.9\<cdot\>w<rsub|<text|<em|Jul>>>+t<rsub|<text|<em|Jul>>><htab|5mm><around*|(|10|)>>>|<row|<cell|w<rsub|<text|<em|Sep>>>>|<cell|=>|<cell|0.9\<cdot\>w<rsub|<text|<em|Aug>>>+t<rsub|<text|<em|Aug>>><htab|5mm><around*|(|11|)>>>|<row|<cell|w<rsub|<text|<em|Oct>>>>|<cell|=>|<cell|0.9\<cdot\>w<rsub|<text|<em|Sep>>>+t<rsub|<text|<em|Sep>>><htab|5mm><around*|(|12|)>>>>>
    </eqnarray*>

    For each <math|c<rsub|i>>, it could be interpretted as\ 

    <\equation*>
      c<rsub|i>=3400\<cdot\>w<rsub|i>-1600\<cdot\>t<rsub|i>
    </equation*>

    Our object is to minimize the toal cost:

    <\equation*>
      c<rsub|<text|<em|May>>>+c<rsub|<text|<em|Jun>>>+c<rsub|<text|<em|Jul>>>+c<rsub|<text|<em|Aug>>>+c<rsub|<text|<em|Sep>>>+c<rsub|<text|<em|Oct>>>
    </equation*>

    and plugging the <em|linear equality constraints> (7) to (12) into it we
    can get the objective function:

    To minimize:

    <\equation*>
      3400\<times\><around*|(|60\<times\><big|sum><rsub|i<rsub|>=0><rsup|5>0.9<rsup|i>+t<rsub|<text|<em|May>>>\<cdot\><big|sum><rsub|j=0><rsup|4>0.9<rsup|j>+t<rsub|<text|<em|Jun>>>\<cdot\><big|sum><rsub|k=0><rsup|3>0.9<rsup|k>+t<rsub|<text|<em|Jul>>>\<cdot\><big|sum><rsub|p=0><rsup|2>0.9<rsup|p>+t<rsub|<text|<em|Aug>>>\<cdot\><big|sum><rsub|q=0><rsup|1>0.9<rsup|q>+t<rsub|<text|<em|Sep>>>\<cdot\>0.9|)>-1600<around*|(|t<rsub|<text|<em|May>>>+t<rsub|<text|<em|Jun>>>+t<rsub|<text|<em|Jul>>>+t<rsub|<text|<em|Aug>>>+t<rsub|<text|<em|Sep>>>+t<rsub|<text|<em|Oct>>>|)>
    </equation*>

    <with|color|blue|<\equation*>
      955860.36+12323.34\<times\>t<rsub|<text|<em|May>>>+10092.6\<times\>t<rsub|<text|<em|Jun>>>+7614\<times\>t<rsub|<text|<em|Jul>>>+4860\<times\>t<rsub|<text|<em|Aug>>>+1800\<times\>t<rsub|<text|<em|Sep>>>-1600\<times\>t<rsub|<text|<em|Oct>>>
    </equation*>>

    \;

    Plugging the <em|linear equality constraints> (7) to (12) into <em|linear
    inequality constraints> (1) to (6), and negating both sides of them, we
    can get new <em|linear inequalitiy constraints> containing up to 6
    variables shown as follows:

    <\eqnarray*>
      <tformat|<table|<row|<cell|-150\<times\>60+100\<cdot\>t<rsub|<text|<em|May>>>>|<cell|\<leqslant\>>|<cell|-8000>>|<row|<cell|-150\<cdot\><around*|(|0.9\<times\>60+t<rsub|<text|<em|May>>>|)>+100\<cdot\>t<rsub|<text|<em|Jun>>>>|<cell|\<leqslant\>>|<cell|-9000>>|<row|<cell|-150\<cdot\><around*|(|0.9<rsup|2>\<times\>60+0.9t<rsub|<text|<em|May>>>+t<rsub|<text|<em|Jun>>><rsub|>|)>+100\<cdot\>t<rsub|<text|<em|Jul>>>>|<cell|\<leqslant\>>|<cell|-7000>>|<row|<cell|-150\<cdot\><around*|(|0.9<rsup|3>\<times\>60+0.9<rsup|2>t<rsub|<text|<em|May>>>+0.9t<rsub|<text|<em|Jun>>>+t<rsub|<text|<em|Jul>>>|)>+100\<cdot\>t<rsub|<text|<em|Aug>>>>|<cell|\<leqslant\>>|<cell|-10000>>|<row|<cell|-150\<cdot\><around*|(|0.9<rsup|4>\<times\>60+0.9<rsup|3>t<rsub|<text|<em|May>>>+0.9<rsup|2>t<rsub|<text|<em|Jun>>>+0.9t<rsub|<text|<em|Jul>>>+t<rsub|<text|<em|Aug>>>|)>+100\<cdot\>t<rsub|<text|<em|Sep>>>>|<cell|\<leqslant\>>|<cell|-9000>>|<row|<cell|-150\<cdot\><around*|(|0.9<rsup|5>\<times\>60+0.9<rsup|4>t<rsub|<text|<em|May>>>+0.9<rsup|3>t<rsub|<text|<em|Jun>>>+0.9<rsup|2>t<rsub|<text|<em|Jul>>>+0.9t<rsub|<text|<em|Aug>>>+t<rsub|<text|<em|Sep>>>|)>+100\<cdot\>t<rsub|<text|<em|Oct>>>>|<cell|\<leqslant\>>|<cell|-11000>>>>
    </eqnarray*>

    <math|\<Rightarrow\>>

    <\eqnarray*>
      <tformat|<table|<row|<cell|100\<cdot\>t<rsub|<text|<em|May>>>>|<cell|\<leqslant\>>|<cell|-8000+150\<times\>60\<times\>0.9<rsup|0><htab|5mm><around*|(|1<rprime|'>|)>>>|<row|<cell|-150\<cdot\>t<rsub|<text|<em|May>>>+100\<cdot\>t<rsub|<text|<em|Jun>>>>|<cell|\<leqslant\>>|<cell|-9000+150\<times\>60\<times\>0.9<rsup|1><htab|5mm><around*|(|2<rprime|'>|)>>>|<row|<cell|-150\<cdot\><around*|(|0.9t<rsub|<text|<em|May>>>+t<rsub|<text|<em|Jun>>><rsub|>|)>+100\<cdot\>t<rsub|<text|<em|Jul>>>>|<cell|\<leqslant\>>|<cell|-7000+150\<times\>60\<times\>0.9<rsup|2><htab|5mm><around*|(|3<rprime|'>|)>>>|<row|<cell|-150\<cdot\><around*|(|0.9<rsup|2>t<rsub|<text|<em|May>>>+0.9t<rsub|<text|<em|Jun>>>+t<rsub|<text|<em|Jul>>>|)>+100\<cdot\>t<rsub|<text|<em|Aug>>>>|<cell|\<leqslant\>>|<cell|-10000+150\<times\>60\<times\>0.9<rsup|3><htab|5mm><around*|(|4<rprime|'>|)>>>|<row|<cell|-150\<cdot\><around*|(|0.9<rsup|3>t<rsub|<text|<em|May>>>+0.9<rsup|2>t<rsub|<text|<em|Jun>>>+0.9t<rsub|<text|<em|Jul>>>+t<rsub|<text|<em|Aug>>>|)>+100\<cdot\>t<rsub|<text|<em|Sep>>>>|<cell|\<leqslant\>>|<cell|-9000+150\<times\>60\<times\>0.9<rsup|4><htab|5mm><around*|(|5<rprime|'>|)>>>|<row|<cell|-150\<cdot\><around*|(|0.9<rsup|4>t<rsub|<text|<em|May>>>+0.9<rsup|3>t<rsub|<text|<em|Jun>>>+0.9<rsup|2>t<rsub|<text|<em|Jul>>>+0.9t<rsub|<text|<em|Aug>>>+t<rsub|<text|<em|Sep>>>|)>+100\<cdot\>t<rsub|<text|<em|Oct>>>>|<cell|\<leqslant\>>|<cell|-11000+150\<times\>60\<times\>0.9<rsup|5><htab|5mm><around*|(|6<rprime|'>|)>>>|<row|<cell|t<rsub|<text|<em|May>>>,t<rsub|<text|<em|Jun>>>,t<rsub|<text|<em|Jul>>>,t<rsub|<text|<em|Aug>>>,t<rsub|<text|<em|Sep>>>,t<rsub|<text|<em|Oct>>>>|<cell|\<geqslant\>>|<cell|0>>>>
    </eqnarray*>

    <item>(5 points) Solve the linear program via Matlab's <strong|linprog>
    routine, and describe the optimal hiring strategy, along with the details
    of how you set up the problem in Matlab. (Type help linprog for details.)

    \;
  </enumerate-numeric>
</body>

<\initial>
  <\collection>
    <associate|page-type|letter>
  </collection>
</initial>

<\references>
  <\collection>
    <associate|auto-1|<tuple|1|?>>
  </collection>
</references>                                                                                                                                                                                                                                                                                                                                                                             ./hw8.tm~                                                                                           0000600 0112121 0112333 00000021703 12134076325 012702  0                                                                                                    ustar   silao_xu                        silao_xu                                                                                                                                                                                                               <TeXmacs|1.0.7.19>

<style|generic>

<\body>
  <doc-data|<doc-title|CS157 Homework 8>|<doc-author|<author-data|<author-name|Silao_xu
  and Tc28>>>>

  <subsection|Problem 1>

  Many industries have to solve some version of the following ``hiring
  problem.'' Suppose you run a business that needs 8000 hours of labor in
  May, 9000 hours in June, 7000 in July, 10,000 in August, 9000 in September,
  and and 11,000 in October. Also, suppose that currently, as May starts, you
  have 60 experienced employees working for you. Each month, each experienced
  employee can either work up to 150 hours for in that month or work up to 50
  hours that month while also training one new hire who will then be ready to
  work the following month (and will be called an ``experienced'' worker the
  following month). At the end of each month, 10% of your experienced
  employees quit. It costs $3400 a month to employ an experienced worker, and
  $1800 a month for each trainee.

  <\enumerate-numeric>
    <item>(10 points) Write a linear program that represents this problem,
    and describe what corresponds to what, and why it accurately represents
    the problem. (Note, do not worry about integrality of the solution; the
    optimum of the linear program may include things that mean, for example,
    ``hire 27.3 people in June''.)

    The variables we define are as follows:

    <\eqnarray*>
      <tformat|<table|<row|<cell|w<rsub|i>>|<cell|=>|<cell|<text|number of
      workers for month <math|i>>>>|<row|<cell|
      t<rsub|i>>|<cell|=>|<cell|<text|number of experienced workers
      participate in the training for month
      <math|i>>>>|<row|<cell|c<rsub|i>>|<cell|=>|<cell|<text|the cost for
      employing in month <math|i>>>>>>
    </eqnarray*>

    The constraints are as follows:

    <\eqnarray*>
      <tformat|<table|<row|<cell|150\<cdot\><around*|(|w<rsub|<text|<em|May>>>-t<rsub|<text|<em|May>>>|)>+50\<cdot\>t<rsub|<text|<em|May>>>>|<cell|\<geqslant\>>|<cell|8000<htab|5mm><around*|(|1|)>>>|<row|<cell|150\<cdot\><around*|(|w<rsub|<text|<em|Jun>>>-t<rsub|<text|<em|Jun>>><rsub|>|)>+50\<cdot\>t<rsub|<text|<em|Jun>>>>|<cell|\<geqslant\>>|<cell|9000<htab|5mm><around*|(|2|)>>>|<row|<cell|150\<cdot\><around*|(|w<rsub|<text|<em|Jul>>>-t<rsub|<text|<em|Jul>>><rsub|>|)>+50\<cdot\>t<rsub|<text|<em|Jul>>>>|<cell|\<geqslant\>>|<cell|7000<htab|5mm><around*|(|3|)>>>|<row|<cell|150\<cdot\><around*|(|w<rsub|<text|<em|Aug>>>-t<rsub|<text|<em|Aug>>><rsub|>|)>+50\<cdot\>t<rsub|<text|<em|Aug>>>>|<cell|\<geqslant\>>|<cell|10000<htab|5mm><around*|(|4|)>>>|<row|<cell|150\<cdot\><around*|(|w<rsub|<text|<em|Sep>>>-t<rsub|<text|<em|Sep>>><rsub|>|)>+50\<cdot\>t<rsub|<text|<em|Sep>>>>|<cell|\<geqslant\>>|<cell|9000<htab|5mm><around*|(|5|)>>>|<row|<cell|150\<cdot\><around*|(|w<rsub|<text|<em|Oct>>>-t<rsub|<text|<em|Oct>>><rsub|>|)>+50\<cdot\>t<rsub|<text|<em|Oct>>>>|<cell|\<geqslant\>>|<cell|11000<htab|5mm><around*|(|6|)>>>|<row|<cell|w<rsub|<text|<em|May>>>>|<cell|=>|<cell|60jj<htab|5mm><around*|(|7|)>>>|<row|<cell|w<rsub|<text|<em|Jun>>>>|<cell|=>|<cell|0.9\<cdot\>w<rsub|<text|<em|May>>>+t<rsub|<text|<em|May>>><htab|5mm><around*|(|8|)>>>|<row|<cell|w<rsub|<text|<em|Jul>>>>|<cell|=>|<cell|0.9\<cdot\>w<rsub|<text|<em|Jun>>>+t<rsub|<text|<em|Jun>>><htab|5mm><around*|(|9|)>>>|<row|<cell|w<rsub|<text|<em|Aug>>>>|<cell|=>|<cell|0.9\<cdot\>w<rsub|<text|<em|Jul>>>+t<rsub|<text|<em|Jul>>><htab|5mm><around*|(|10|)>>>|<row|<cell|w<rsub|<text|<em|Sep>>>>|<cell|=>|<cell|0.9\<cdot\>w<rsub|<text|<em|Aug>>>+t<rsub|<text|<em|Aug>>><htab|5mm><around*|(|11|)>>>|<row|<cell|w<rsub|<text|<em|Oct>>>>|<cell|=>|<cell|0.9\<cdot\>w<rsub|<text|<em|Sep>>>+t<rsub|<text|<em|Sep>>><htab|5mm><around*|(|12|)>>>>>
    </eqnarray*>

    For each <math|c<rsub|i>>, it could be interpretted as\ 

    <\equation*>
      c<rsub|i>=3400\<cdot\>w<rsub|i>-1600\<cdot\>t<rsub|i>
    </equation*>

    Our object is to minimize the toal cost:

    <\equation*>
      c<rsub|<text|<em|May>>>+c<rsub|<text|<em|Jun>>>+c<rsub|<text|<em|Jul>>>+c<rsub|<text|<em|Aug>>>+c<rsub|<text|<em|Sep>>>+c<rsub|<text|<em|Oct>>>
    </equation*>

    and plugging the <em|linear equality constraints> (7) to (12) into it we
    can get the objective function:

    To minimize:

    <\equation*>
      3400\<times\><around*|(|60\<times\><big|sum><rsub|i<rsub|>=0><rsup|5>0.9<rsup|i>+t<rsub|<text|<em|May>>>\<cdot\><big|sum><rsub|j=0><rsup|4>0.9<rsup|j>+t<rsub|<text|<em|Jun>>>\<cdot\><big|sum><rsub|k=0><rsup|3>0.9<rsup|k>+t<rsub|<text|<em|Jul>>>\<cdot\><big|sum><rsub|p=0><rsup|2>0.9<rsup|p>+t<rsub|<text|<em|Aug>>>\<cdot\><big|sum><rsub|q=0><rsup|1>0.9<rsup|q>+t<rsub|<text|<em|Sep>>>\<cdot\>0.9|)>-1600<around*|(|t<rsub|<text|<em|May>>>+t<rsub|<text|<em|Jun>>>+t<rsub|<text|<em|Jul>>>+t<rsub|<text|<em|Aug>>>+t<rsub|<text|<em|Sep>>>+t<rsub|<text|<em|Oct>>>|)>
    </equation*>

    <with|color|blue|<\equation*>
      955860.36+12323.34\<times\>t<rsub|<text|<em|May>>>+10092.6\<times\>t<rsub|<text|<em|Jun>>>+7614\<times\>t<rsub|<text|<em|Jul>>>+4860\<times\>t<rsub|<text|<em|Aug>>>+1800\<times\>t<rsub|<text|<em|Sep>>>-1600\<times\>t<rsub|<text|<em|Oct>>>
    </equation*>>

    \;

    Plugging the <em|linear equality constraints> (7) to (12) into <em|linear
    inequality constraints> (1) to (6), and negating both sides of them, we
    can get new <em|linear inequalitiy constraints> containing up to 6
    variables shown as follows:

    <\eqnarray*>
      <tformat|<table|<row|<cell|-150\<times\>60+100\<cdot\>t<rsub|<text|<em|May>>>>|<cell|\<leqslant\>>|<cell|-8000>>|<row|<cell|-150\<cdot\><around*|(|0.9\<times\>60+t<rsub|<text|<em|May>>>|)>+100\<cdot\>t<rsub|<text|<em|Jun>>>>|<cell|\<leqslant\>>|<cell|-9000>>|<row|<cell|-150\<cdot\><around*|(|0.9<rsup|2>\<times\>60+0.9t<rsub|<text|<em|May>>>+t<rsub|<text|<em|Jun>>><rsub|>|)>+100\<cdot\>t<rsub|<text|<em|Jul>>>>|<cell|\<leqslant\>>|<cell|-7000>>|<row|<cell|-150\<cdot\><around*|(|0.9<rsup|3>\<times\>60+0.9<rsup|2>t<rsub|<text|<em|May>>>+0.9t<rsub|<text|<em|Jun>>>+t<rsub|<text|<em|Jul>>>|)>+100\<cdot\>t<rsub|<text|<em|Aug>>>>|<cell|\<leqslant\>>|<cell|-10000>>|<row|<cell|-150\<cdot\><around*|(|0.9<rsup|4>\<times\>60+0.9<rsup|3>t<rsub|<text|<em|May>>>+0.9<rsup|2>t<rsub|<text|<em|Jun>>>+0.9t<rsub|<text|<em|Jul>>>+t<rsub|<text|<em|Aug>>>|)>+100\<cdot\>t<rsub|<text|<em|Sep>>>>|<cell|\<leqslant\>>|<cell|-9000>>|<row|<cell|-150\<cdot\><around*|(|0.9<rsup|5>\<times\>60+0.9<rsup|4>t<rsub|<text|<em|May>>>+0.9<rsup|3>t<rsub|<text|<em|Jun>>>+0.9<rsup|2>t<rsub|<text|<em|Jul>>>+0.9t<rsub|<text|<em|Aug>>>+t<rsub|<text|<em|Sep>>>|)>+100\<cdot\>t<rsub|<text|<em|Oct>>>>|<cell|\<leqslant\>>|<cell|-11000>>>>
    </eqnarray*>

    <math|\<Rightarrow\>>

    <\eqnarray*>
      <tformat|<table|<row|<cell|100\<cdot\>t<rsub|<text|<em|May>>>>|<cell|\<leqslant\>>|<cell|-8000+150\<times\>60\<times\>0.9<rsup|0><htab|5mm><around*|(|1<rprime|'>|)>>>|<row|<cell|-150\<cdot\>t<rsub|<text|<em|May>>>+100\<cdot\>t<rsub|<text|<em|Jun>>>>|<cell|\<leqslant\>>|<cell|-9000+150\<times\>60\<times\>0.9<rsup|1><htab|5mm><around*|(|2<rprime|'>|)>>>|<row|<cell|-150\<cdot\><around*|(|0.9t<rsub|<text|<em|May>>>+t<rsub|<text|<em|Jun>>><rsub|>|)>+100\<cdot\>t<rsub|<text|<em|Jul>>>>|<cell|\<leqslant\>>|<cell|-7000+150\<times\>60\<times\>0.9<rsup|2><htab|5mm><around*|(|3<rprime|'>|)>>>|<row|<cell|-150\<cdot\><around*|(|0.9<rsup|2>t<rsub|<text|<em|May>>>+0.9t<rsub|<text|<em|Jun>>>+t<rsub|<text|<em|Jul>>>|)>+100\<cdot\>t<rsub|<text|<em|Aug>>>>|<cell|\<leqslant\>>|<cell|-10000+150\<times\>60\<times\>0.9<rsup|3><htab|5mm><around*|(|4<rprime|'>|)>>>|<row|<cell|-150\<cdot\><around*|(|0.9<rsup|3>t<rsub|<text|<em|May>>>+0.9<rsup|2>t<rsub|<text|<em|Jun>>>+0.9t<rsub|<text|<em|Jul>>>+t<rsub|<text|<em|Aug>>>|)>+100\<cdot\>t<rsub|<text|<em|Sep>>>>|<cell|\<leqslant\>>|<cell|-9000+150\<times\>60\<times\>0.9<rsup|4><htab|5mm><around*|(|5<rprime|'>|)>>>|<row|<cell|-150\<cdot\><around*|(|0.9<rsup|4>t<rsub|<text|<em|May>>>+0.9<rsup|3>t<rsub|<text|<em|Jun>>>+0.9<rsup|2>t<rsub|<text|<em|Jul>>>+0.9t<rsub|<text|<em|Aug>>>+t<rsub|<text|<em|Sep>>>|)>+100\<cdot\>t<rsub|<text|<em|Oct>>>>|<cell|\<leqslant\>>|<cell|-11000+150\<times\>60\<times\>0.9<rsup|5><htab|5mm><around*|(|6<rprime|'>|)>>>|<row|<cell|t<rsub|<text|<em|May>>>,t<rsub|<text|<em|Jun>>>,t<rsub|<text|<em|Jul>>>,t<rsub|<text|<em|Aug>>>,t<rsub|<text|<em|Sep>>>,t<rsub|<text|<em|Oct>>>>|<cell|\<geqslant\>>|<cell|0>>>>
    </eqnarray*>

    <item>(5 points) Solve the linear program via Matlab's <strong|linprog>
    routine, and describe the optimal hiring strategy, along with the details
    of how you set up the problem in Matlab. (Type help linprog for details.)

    \;
  </enumerate-numeric>
</body>

<\initial>
  <\collection>
    <associate|page-type|letter>
  </collection>
</initial>

<\references>
  <\collection>
    <associate|auto-1|<tuple|1|?>>
  </collection>
</references>

<\auxiliary>
  <\collection>
    <\associate|toc>
      <with|par-left|<quote|1.5fn>|Problem 1
      <datoms|<macro|x|<repeat|<arg|x>|<with|font-series|medium|<with|font-size|1|<space|0.2fn>.<space|0.2fn>>>>>|<htab|5mm>>
      <no-break><pageref|auto-1>>
    </associate>
  </collection>
</auxiliary>                                                             ./hw8_handout.pdf                                                                                   0000600 0112121 0112333 00000247670 12131427776 014403  0                                                                                                    ustar   silao_xu                        silao_xu                                                                                                                                                                                                               %PDF-1.4
%�쏢
6 0 obj
<</Length 7 0 R/Filter /FlateDecode>>
stream
x��=َ�q�+�1 ,��f��>V��,K��]a=h���H9���zGDfUE^�՜�`������b��俟�}�w�/o����^>��@Ҁ��׳���Ex1E��������I;w፝����>��ᗗG1y�T��]u0�� ����ǿ��d(�2~���t������_G+�V�+|v�����M�J^_�$�����RL�D��<��Ŵ����I�ZLJ9���910��8��`��Gh]��u���8��-N�� ��}�"��|�X�Ty[l�y��o�Q|���VZ{x�����p��(�n҇��z2"�љ��%����r˂^G�0�ą�8�sa��ŋ��̢�?2�z�P0%��.�	�%�J!�ևO�7�C1�  Њ��p�~��:$oH]HD�S�!7Y@��Q�II�h<��G"/ 
��S�h�^�v��/޳1��� ���s������*�Z���S�0�B|����|�ŗ�9��K&���;�q � p[��=�Sz�Q��p`�Ź�ɀ*K΀i#(~�l(�D�tH�\��"pFZ~��!.�+^�>��B���}C��h��)x��-g}��ӈ�y�	*�1"�-��kL���x.�L���WL��G��-�U� �A�t��a"��~���x�(`����Z��j�E��У�.�S�g�[d�ݤ�d(y�k��la����I5Y��)h"8m���Ґ��҇� t�':9|�6TQ��#��&݀J(ڑ��J_F�_>���u�����\�}d325^�)�(��
�� �'�{�x��Ȁ��Y �~��������:P�X7��!�{���ڛ�����mcD$j���3�ul*��Ŧ���fT���x��޿Y(o���6�y��@`��Ξ��K�/�'w�a5�YWf�篟�gNo�R��b��i��>���ˠ@ j�xJN��)1��01p�`�68G�&�Rѣ6B>�Y�Y���~�e-����3��Hˣ\����E��/_-/��/�-/��/_//a�(�j���u`X^חjy��O������:v�W���+�i��%:%& E8��h�G�>6��D���((�D/(�c&zt�phqQ�Y�ǰKp����݀�j6�/\��F;kR2�㧌'��+DK��7C�[p�uO���__Z2�ka�+[[^K3��T��A�e�Q�K@���,����fmb����h��#�()+8�s�KI�(��P��.�܋䚐���_�J�pX2���H����L�ڄ͸Y�~�)ɯF��d�h���! -���շ�?�a#U�OjH^��t�_�\
��O�=aC�+'-K&�ίc����ݷ��<�
i2�i�UsJ�)X�����f��|>vh�$���	��?X��m)����:�k���	�V��RO�F�/�CV�� �����u��9���&N��sUP~q�E�r�Lyxxy�~��a�n9�G6!g���h>��9U_%� ���X���`,�~���6��" �
���s�������0�*�C	`��W�}���G
m��_Ia.T���K���1�(��p�*���zag�X	gJ��ߧ}�ߤ����z�B�3ȑ�B_1Y�R(4T�2>�'/�@�`9�o�iyp������Mf�8ɸX}=v��|@��:B�<;���`V0`z#�  ��'�=Z�k���\w��`G)�-ࠀ���;��#l+�������l����0���&ij�FM����r1�	�d���2���������c饹�5�k��C\�F٢5�eT���:��9��JYg�Ptݲ|�ax|�!֫	M�A�cd-��ދ��:*�y�Q9�ӫ�/pO��E��==\�m�E���y�i(�ȍ�w�KΡ9�Y$)C*�mXX�{6E��@�����C��q�y����.;�c%=c�8v�h�xyDs�Cmi����&W�1��CXy����nǤ7����~Ƹ�R����CۈGXk�P
 ���t]�~���0"�_�9Gɾ?c�\��L�2CS�&��:3o/���\c@~�-�TI��pE�p��xa�'�[$���H�JM˺ZbONř?ۥs|�!�?r<���$˳4KC$�6|H_ȧ�HB`Lŧ�J'�7�M�;�eOv��Թ��
��ϴ =�#�H�&�K&�1�a�E��*=z.��pm�eY�ӊ���/��y��0�e�@�2ĉ�'EѢt��la��!���K�+��b�a�<�M��4^��a�Z��:>�/�.�#�ά�H�RH-�>��_ct����.A��V+�5�ǚI�bf�=�F:~��B��&5�')���{��m�A����aܒ+�:��L8uRw�d���C�{�q`�.����C��;^�� �?!�Q�A����"��0'x�DgfS�\6���#p�d�[������.�:P�R��g7����s�P��N�{����xt��pn˿`R��?���)�6�n#�iŐO����i0m ����]��'D����^�m
��"ɾU�E�w��[�#T�Ar½��6�V�8�S�Niň���5��?фD����~͓e��:<�$�+�z��F{�U� u#Ѐ�S�̑8hh�a�Yk��C�Gֶ%��`aC��Fy���A�+p^��(��2`o��M�.�(��X�R�H��ˢ���p�;�fgs �ټ����b�2��i	�z��*�H�b�	���ݍ+�1�2�+X�E�1����QӖ���`	��F��d���?��[�k��#��9Z]*˹����_1<i�*f#�D����p�_��
��*E�q��l(�Mʋ�&ܖJ�J<��3C	#�[s�j�e�|r��G9���ª���V�W�@��Lx�±���M�4�	Ǜ�J��R��������<�׊�T�h4�z�qF5��@ja���h�Pfh����#Ws��騖��Ľ~O�B��D���;EE��G��nk�]IC������+��r�/>����]���.�7��.�ՊXiX!url����4�e����`��i�3�Haaz���F}�ĄXX�#@pk��m�_3a����ڀ|�+V��LuB��#M���V�F�T��q�$:^�XY�Q+b��B3��(H[��Q0�H����%���JF^�{�W�[���d*�hJg�$T;���ԐV5��yy�al�^%z��\+)K�z�U�N�bX�>A�_Y��zM�� ���*,4f�
��N�0T�9XU<�9�gw�.�gp��V�W�~���Z�΋�G���M?�������d�u�$�I4�>(���lﻠ<R���s:���簌B9�M�p]=G���Z��CY��6,��?���Hv��)� �����6�D0Q��򼝏����0�a@hʶ�v9�y���J7�(W[�=�mP�
z�gi��`dۦF�p�j]1�aYfcfm���j����AⳒp�87�Q0Ό�b�T���?�G��G��Dna�t��#��b��yչԵ-�٬�a�6^?7���<�'j�$�LB���aX�`1l�/�B�8����N�#Η2��$6�mx�򃩭Swr7p�}Ս���O<�QrI�$�����H�v�"��D��N�PJ�B��:�%��Rt��E���f}�^_.��x�F�_.f���U�@�I$�J.n�&H"د�h��z(~g�n(%:z��Yٷ[�sB�%��0\��n�'���Ȯ��9 �-��-���j�r����84�F�ԼC�]�3@ V����4DZ?���?\s,�p�A5���k��l4e4V礍D9��������Nqa�9~�o���1 m� ;8��m��Wz�@�4Ggu�Yׯ�!A�&��{��c��N�����w�f8���������G��`��Y�Q�������.��;��B�&Hs�&����%'��%��ܸd�Q�d��*�k�)���� \i)�"0����Jh.���ґ��rЮ�
�N�Hw���[�w7;ѩ&
:���Wy�� �@�*�ucdoL�[,7�XRV��umBG��DZ$��4i�;���%i�ή�ﳒ+�Q�-��wow����	G{ �|��|�E��4�a}#��#e�5�B���
�:�!�7?�8�ԩ�K��K�L2z}j���5�!#����FJ<��<�9N��F3�)�����g�*$v
��b�ʡqr�v�;�����
K&l�e����4�(i�*���8���m,v���t�F��2'�mO^lj�ԷAK���5�b�`Ğ+�82���MǞ��+|N�cQ��̼�",��5��ն+F�oq95����4��S�v$<M�0M�ea�*e��hs�罍��\�܊`b����=Տ)C�EC�2|���������{+ ���^�`�g��a)+�R��3xZ�X���w���=�	F{�s����n2��zS�	��j����� �\\U��뻵)��$���,\�V{��ky^���n�BU�\:m�o�+�1Rh�Ѯ�g0�|��cQ����P���ە��h�V��4�W}�^��nfJ��ۮ!D`��?�1�Ta���-�+2E	>͡��]��s%���]�;�L�X������*ўB�۴�@�]El�}{��5���Z֤�`�mQ�Z���X�wr�
ʰ��|l�+]�#�^�a~���A���9�^qy�����c0t,m�mH��H��kAij����.��p#��}P�.b��-uOO�T��)et!�-��(%l7d��s㑑S^�"��+�=CRop{dͬ|y���#!�8@��g����t�ط��f�¥(ε�O�A�K�5[`mP�9�_�y��0.�w�s��`�ŕgZ`���[�H8p���k��(��t"���ܤ�����iDܗ^���M�.��It�٦_��,p7��4�nr��A�e����� ��2�ދPpbp�OXf5k��
�$��2�n�o�X>����͂���N�|���!�躌M��mi��}֝ga+�=+a��b%G��U�4k��p�\o�e@!�~<��A&oG�9�/�ʲ�UQ��)p��m�*=�s�p$�?��ʡ����$J��;�q���{��{�z�{���~��蔮9�:��K�,�r�:!ɹ��Zp���k�i��)����v�>xn�,F52��M	l��ESG������dw��$Z��wԹ��y4���[4z���0�$���Y�Ț&ؿ�*������8�0i6h�ֵ��Y�� ,�X�;PiX�N~� 2V>q����	�$�GY�Z������e�L&˸�c7a���-��+l�6����B�B`�@t�&�Ιe#�8��6	u�]�e�F�����	͢@Ù#��npj���',�)�����D{	�5�@��L}JXt��IyPn�+j��"�@ɔ�OD�s�m�^�V�?X�TNߗ�r@���x������U57O1w��s_"ڇ�n��Y�n��B�����|:��_'�
׶��Clm����	��d�eg��j0ʟs��cA���CV�AU� a��r��b׹mmgh���=�6� �-�B��&9EM��]��Gs��a���^g0���d��4�����ܗw���&Ph]�7�D�i�fΨ�c�F�>�h�ɤ�<�)�a�be�u;�J�;Wk�[�0c��aDx���X.௸�;��m��C�0��Q��Q�x�X캸ƕ�~�V�Yˁ�St
�Uҟx�Ϊو�u럻��u�,[ө>�Io6E���������;~�W�GRx���[k�X��v���";^���vYI��[��{!�skA����v��-�.̀/S��n���Y�6�vR���uv�Qy�����M�ze�3��Ie�M��['��v5k�&o���L�7�x�!_�o����Q͌���ٖZ�|�2
�W|�g	�7=0P/6���j�Z~Wgd�RG�@��[�C�\�Mo�t4d�H��z�uq$O6
,a+R�����Th�wn�>/��;�I��w�t�͓%��(_Z�zܦC`k������ ����}��^�:�dY�n1]u4^�
���x�D��(�:M�jăÄ����M��������,�rpI��(���(m��̴�T:�P�r��W�֛��~A�G�:�{�#��}�K�0�\[��w#�.�����۴&޵m듫JƝ�i 1���<�V�T^��7#ˈ�G���K��Zq�k���DW�1z)w�jk'%�7�K�4'ԝw)w���)���:��=U��i�qCX֡�T҄��-@P����`!�x����҇i�k2���`l��U�Ԕp͢l����j�&DV�~���)�=�=6fs ����&�����_=~���� !�!endstream
endobj
7 0 obj
6472
endobj
43 0 obj
<</Length 44 0 R/Filter /FlateDecode>>
stream
x��]ُ�qO^��y��%���q߇��pb���|	,#��C�r��7���ꞙꞮ�Yri���l}Wկ���LM�L�?��_�z�/��˛G����ߗ�~x���Y��ׯ�~�ex1e��ٓ�ʏ�Y���,:?�hϞ�z���o�/�cPڜ�t~a��t2'���_������(3��=y?�ݹ�T�ɛp��g�����
;5^x~��!���s�����l��WΜ��)X7��OimRfҮ)��G3��O؇���tzM�.�`J����4���{��,�yw2J�ạE�\8��~J��2�)S�م�t~����z�^{�лS�'�7���ü����	�e�,t��uq���C�ӗ��lb��/���\T���:t޼~ʆ|����F����D{�)6q)5��j��OSeoO?ⴕ��bn:�=��h�374�<�`w������T���O��%���u�i.^�h����V=+*�e���ί�=�66���=�*�0����lp�'���]�G6���{�ܙ���2q�\��oX�e���
��%h�b�
�8U C1��y�غ!ٖ�0?7�6��sԳ֓�ja4���Q[�f@�F/��~Y̨k?��u��'}ϭ�9��������F����t�M������sk�:���`��h`h��B3t.��8�ݞ+w}��������� ���7��eզYu�-	fY���I�3p`e˩� A��)� ��&��;�n�-������*���\,L�h�Q�3Jkr�9׎z��\�y�bΣC�p�a�-��I��U���q̞�3)`[�5�ï���i�LΌ���LT?= ��@���L��1N��F3�_Ut�.��m�dU�r��3�FE�p��%T �[f�3	�#��M 91����?�$��!ߔ冤P0o?=��)�%k�"p��5�� ��6�J���-5jȞ�@��g�o~	kq
y���1�'�C�k�v#qL�S;&��e�7���Y;e��4os#�����l}?Z1��W��Ȳ�gF�6�w!f��c����+���`?�C������9�����gwjx� ?TRwl+sA��&w��]�k����i���ë����z~�
����<��cs/6�#���ww�����������=OdHj����ٜȄw�µL�c������њ:D�F�mڇ��$9�4��2^�R�x������Оhz�� ���a*��r\��������������������������f}����z}y5���<���wzn����L�C�N!��!%��뢢��!&��Si`�A#`[.��-K���c���m u�Ar�))�o�qty��<��/'W�AޤI8+��v'`��6��#����=7iYo
"�0��)ˁP]��J_8���� �4��=`�0I��҃Y9 7J�F�w-�3��ecS;޻��0z���Z�j�B)z=�� ;X�Q��4%E���������|�Ӯ��Z>aNF|�u�9�񘭍A���s%�w�c���.S��!��1�h��6C����7�2���U��mp�FRIu�iNjR�k��-�̥]�eC��zt]��j�6�[�!�H"c�5o;�9S���$�W�����M�V%Ӵ�7t���z�����l�����FEdRל� ٵt�t,zځ�*/7�D� �Ae�	�� #2�w�@�Q.�����E�l����"��S��x�{���a~;�G ��� i�}2* �Mf�6ڍq	!6�~�&�V򚱊���ـSq����X)��Oq�+���^|6z�v�&�R�\��x�]wWEȫN�L�M׬�?���UHsw0�U� ��zJ�%��%i�C�d�w |���9�qr}[�GfL�u�)���M��iM}|���2�|���NX�d'|Vw'�� zDuY[8�Jӝ��S$G�h3|h�$7��#�T���fr��B�O}�b��em:��t7��D�������~��~;X��Kc�fݘ�H/����r�DU�紂S[/g@E�Y�2���&��
�mm�(�z�чaE�Z�9YΖR��uZ�rQx�H艬��Eٺ�(�t�p�����e�*"�a�e�W�[�`B��"��[�DQ����M1���|#�fG@8���}�~�a$����� o�E�c�;G:W�f~1�K����Amo]�7��g�9��36��u������c���6����Z�8���Kk�ľ�v� ���Ө��*�_�~������A'ؑ7sg��^��ݞFb�����zU�FK̞JRA���iQ��z���+�t�)I9`\�,���5OhR����/N9w
��+�f�z�FU8�P�'l]��^]��G�J�v�s�M�pc}�C#�cz[®���R�ُ����%J��d Bإ�2@�^o�:�ܟ�;G�W-�r�b��oee.�Y� �a*�`?�{�|Q�ךݱv�C�}�3b���n�p�NP`��N�r�#�ަB�����	Z@�h\P�OjĤ�hxN=�2�a�0�#�{򞄰�X7���C��B���`7��r앐Hf���������_j����_�{#K���d�r���*֜QqdBck���K�ymQ����C��x��[׶�ю�m$�����xފ �ڍk�MQ�eccC&O��kQ����_~V{kk;�5�&�[� wmnbN�;����!���=,�X஖�����2b�k��v9�Ja:z�h>+�@��JPK�_��'�=�ńF����%تj�[�R:�ƹU�}�8+o˟�jI���St��]����<΁��r$��$��@��׃Q*���HC$������7&\�2��!���im���ط��U�g�S��{�hϮ�ڍ[!�7#�����F�X��w|y�ot d� Я�Ħ{�,�eQ���L�A��b����f%����٠��;;�,GB\����C$�qN�a��9��4q�������� �wf� C���y<��!^/�%�<LRNdQ\�ݖ�>�J������L��JC#zv��������F
�s���_#���`��.�a�XN"�\�=����Y�����W'�DS3���]X0;���}|��#=�^9��a��ow��h,�#_5�0(oE#h��nNO��縕T��p(]��2&*J{9����1�}'��E�HV~��@��8�e����3@�2�ƛaF�y�~(qh�4�yy,�
v��uRA���6���9�b�1�M>":B~�>���U�F�b|Ce�(������K��[�nvI�¢����0"�����`��f,�fŸ%5�,�kFy$}����O9"�(���U��Do��12"EK[J�I�-������H�3�hL�R��u��C����������^�z�ՙְ3�\7��  :����^�j�1�W�ѠGV%�LK�Y�Χ�@cЕm8OM=�m��_7T�@>1�=�ã'?�9��xF1y�b2Q�Z$��Hf|�j��
j����K���k��ˏ���q���[+���'H�̏���y��Hz��ޔ]� ���e")�`��fǰ�Ee����D����n��-x���m#�k=�Cj|*,�K졉XDo�'�����R�j�u�n��}�U�	����W�;�"�ʩ]�U�R#��!���|S�Z+�ܖ~��y���P. T�=��@�`���"�X���F���L��c�ɀ�c�\�ϠƵ�]�uG��p��(�ѮV�/[�a��A�J0t�a`�*��W�	z��0Q�y�f��Tl,��Ynѭ���Нw���
�am+3x�b2�� kq�\����p`�X����ӈaM-�,�7e���r� �,n���$�V[yQ�o���kݻ�v:L������'G)ה����$?a�������?�oXJVw�A��E����]����鼘Z���`�3�	���
;٭�'\���Hl�ac}D�x�ɠ��Ư�K�m�5v�;/�N���5��g#(/����܇<͋�m�l��}v����.0���;���`�s������yB�������9���^${.���ˉGv�T�I�G_L��<���G�֬Y�5`�m��〙H��o=��7-
��7��Y<cd�!^E+i����+֜c�.�y!J>͝`bk&���E�b@��AЦ���w�<�I������vf��B;��	F�bD�����9oBw���4�>�]�f�HK��a���B���#\�� �cx��c�⣎G=.�/�=>��GID��Q�G���Z�Fv�-�2�Șy�M�@e�x:UML�F��߷���������{WR۰�U��`�>XB�}4;���vm���5�m'x�h��E�c�{���P������X��jE�q[i��V��T�a�=��:%G��Sƕ� 3!���;�W��5H�]�/<��%_+�`�!�+d!-�Ǭ[��=������a�k�r���]t�V�z�աw��k`,bh8��+�CZ�z[����#��}���b�7I�rqv)�A[������F�Q�
nJt�cv�b��@'���R��T�K���R/�~ؕV�X�l^>Ɩ�V��3�0�]�LV�!MV>Re��b��}�ȏ���G@���,�`��==�U�mY���Np����)H����&$H�.�CE�����~:�o�F�N�oV�ǵ�`��k-�5
S��M���W"T���>u���2�q��;pZ��x���Μ�5ny��&��,�3��<�N���^�,ˣL@��nӺ�$a}3ذ����
P��`���4M[�щWю��N��P�k�l(j� Z@Iy� R���9� �����ШR:G{X �I����19&de�z����%BeF��vXJ�Sr혣V����B⩫M�.����s���WS+�C)����L����=n�S�i[�I������gw��t�J�<8��w���nr.;����g�$�R#YW�o��� e0�]�Ш)3$�) 5@M�ɣ���B�pXڥ&�x���Ge���V�')L�?��N�)�8�8|b��wP_�Ǚ(v�`�1fQ=d�^=w�LuL��	cL��Ql�J�,�R+TYϱbV��7S�L̒�`1N��]S�3E�s���`����%�ˠ��R���ӫP\ZO����eq�_�UH�@mЩ>��&�C���O�� 7��)E#{F���⦴p�����~�\�2�O�<b���������7ݩ��eŤ��O��5l�E�����S;�s�"Uv<ߴ��#��~������>��Q
��X��heÔ����\(��'��u���Y'B�,Ii��ή����<Zmfޛ�J"�L��!�4�W��������q��<+�T?�����}�ƬB�qX�c���� ��\!xE���)��p�!��>*���a�mXP���v�g�-������f{Pm�\=,�vTC"�LSj��5x�� ���>��5�(a0#�����R��+JE?(o�D}8�&xSZ�(�> ��V�� Ϋ2�ڄ��[��?�|^g� aՊԐ��R�<��LdSpץPm)rH8��MQ{�W��}1�>�:��1�6M��1���Uv[^v'w ��/y��(*�/��7qpk,j���t7��J1����y����+�����,��K9�:��goZ@~�6ر���9��y@{�y�Ըr�Ihlt/��7�^�?���6��P�FO��[����M@����prL-%�6�����
f�̳5Y�}wA�|WM�V(��Ve;(q:�ƥ�g1s]��L�{ڄ�IM�VN�����+�}s�
�12�����݉~����a+|Z2�����\��$H�A�׾T��h���>W�2����ötuA2C;�֛��K\�Z������FsG)�����{�]k�N��PB4b��\��"r�S���>�����\�`y��s�z
*ֹk�1��V�X�f:�(&��U�*4���x��h��\{�+��"U ��7 A������@�X�	yo\=v�a�(�<���P�}^V�6%?q�Ѹ�ӜML�}SFr$E�.�1��6y�RFu�[����WC� �9��S�}qӽ��%�,�>�ؚ���F	��-�Fv��f����d���*�Ȁ >N8�(zŘ�/�p���b���[�̡8�����˲`���1���ЗL���r���w%�bv�a�}��ZN��B��#�qs�
~�n��0o���@�5��2��rj-�t�⃕�g����
0͝���Qr͹jl�B=���+?��Ҷl��Gm��b�
�3�.��_m��ƪx�S��FЉ�E��Z� �'U���M	/��.L���O�v%���HUW��i����;�%��D�����)�y���m^����T6f�8E�[�L{��a!m��~J_��h/;�a���̩���vf����W0�^��Kt����=VE�~�ј�jH��|q�~������t�������l��<�_v�#��M�8���P�������뗌���B���.xݰ��q��z��@��=-�aXs�[���� ӱ Q�/d��U�ei����&pd��k�b�Z1%��:�ځ��t�sg�>?�&���ݽ/}��T��~�� 1��J� 	t�Q��ג�]�%�r����n�I��S G�i�b�w��t�u��J�~�T���J�E����R�.�����:t>J(�}��KQ�y�� :�ԭd՞�A���p�+�ٙƽ�|ҥ(Ik����u@\���,���#���q��K����Ӗ�)Q�1`��u�����b�{�y����b��o�1��;n�w�����,�9�~�v�:L�S�<�APޜ�B�m�!u`&��Ǿ*��w�V�����$�`^����i�їR7�#��"!Vm��'�H|Y���W }��-���*�YU8e\qP�|���/��*��V�X��q��|e',P�.>��s�.e�'oU�ៀ����",ϸ�6ҕq^�ڼ�8����c�#(��i��`/,de܎�j��>��w˖�C���<�?��K��L�yk1�c ��c���6�~��%R{[������d�;��� \K�MZZ�꾧�)�n40��ٰ����X�7�����73�*��p4���Gc��q�
V���GVE�ݰ���'��s�[+H6��z�і�:�2�6U�ݖ7��8w,�}�S�9�|���PCɯNn>U!��3Nm��.iٞ�����٘U��לwl=��4�u^ ��z��
�g�㕧�������O������'�endstream
endobj
44 0 obj
7467
endobj
51 0 obj
<</Length 52 0 R/Filter /FlateDecode>>
stream
x��=i��q���O��Ƿ	߸�C��B,�H��"�P\���D���SU=GuM��y���	gg{��������T��T�3��������.���P�_¿g�_hjp9�����oB�/����|���|�/�l���AG{����ׇ/��j�1(m_]mr�N�}�����CO:�2�����k��wWjP�&o��>�l�ׇة�*��|ѧ`�L����?`��r��L����|HK�2�zM�>�i&_a�+o��5=���)}�￥YE(^���ʲ�w��m��hsbN�G��)þ�n�W�Ƹ���[��q�V9�����[?z�=��^;k���Y��e,H���-�������8$�������9��7WG���z㣼)�%G ԃ�>��V�8�?�[���Ͼ�ǲ(X,��)���l�qF#�0�!���j8����3�^����z�,����@���ʺ	j��wg�y�(�bUuNpx�&���N,%�v��s�zM�����C�!�8��[W��њ��� *��&���Ɵ��!�M���p��0�
v���@[��gk��5�oS��)����U�C��y��f;M{��8�gk�M� ��}9��L4���	/�h�s�@n�̘]�1Ve��"��d;��46�E�D
X��uc�y�z�a<^Y���{��ò���X� �����/ �!!L�!�ќa^��NN�	d�fv�� �����OW+�\i֒��[�����1�G����a^>�}z��t�՟y<ˇ���A4���o��A�%h3��FRV���:#��_�5<��mM��+����>�8��f6N!�T�`̡y�<��$�N��k ��`Wǐ 
:T�zx�k�	���jތJq9B�d'��ӣ	�кf�e#mE!9�8�e_
t���-=���|�8ǩ�%� H=�g��@�p�Ho�tqb�� �^(!�wO��Lq��L��5]Nq�($����:(�L�S��f��.�J{�l�a�	��� ;^V93�XXO�Q��=a�I�З��;}� � �W���?�ω��\�¾�P摵�6�'�?)�}�[r�ܜw)D�i��\�,T�k��ލap&1��8�0�:Ԣd;~4ّy](h����X&ÈfF;6w>N,��M`w5�ytZ�����i�#РBʳ��lYe����%T�Rm�"��0I��V��F�֤�1$��n�Ԥ]O������	�Q5 65pX�f6�B3���x�-Q����<-�y�>˼�m���t� �=m>��Ĉ���~���9�>�j��vo�	i�8���/s�o�0Ѱ�\ǀҞ�&喜���%�'b����,��g�@��n)~��L��#bEkCk=��	�P�Y��y'�ɐl��#SL�zT��L8�O�ߴf�X`QC�{Mt��a<|G��Y�зXI����"�ź���Ȑ+��&Qd��A
���=_3Z�y�$;����I�#�:;�mP�Q�uFEA�+�ː�ƻ�4�6��]�ۛ��i���a���՟Y4���FPn�b(g1�6�ˊ}V�3� �u��{�q�+!ٰJhJ<j>y��ge*�y!ZY��#S���@��ΗG��Ѹ�����}���Ӑa�p�|���h���%��$v�rrQՂ�����8v3nCS��	�QȄv'��M�zƎ�+�Qi�_8�Z �����Q�7'2P=�����q����ԣb�O9��!��lj�������b5��E[�s��3�m����y���bqGH�"����zS�ދp�ж�m�O���+�
�h�Q����a�C+����A�"
�RE�(1��Z!X�&l���0�������������ϛ�O�Ǘ��<�_�]���C�o_7��n��9ګ����Ys꫙���839����h7�����_��f���m��9�9�>jB����Fӯ�@��ms+��� p���NU�;J���>xD�;�<�!�g#ӆ�Ĵ�̂��,��W-�%������M���'=�l� �WO�--|���B�c�5�2�kt���GC�1а�mO��x�*�r�ʮ��i	L�.�2��4|�/"������d�HXuΣ2���>Ɲ�ё����g}��y�'ڔ�!q��lۼ3Eoߧf���в͐AN�*4o��Ζ{6�M��ma&��J�#�
iB��q[�Mg��=�c(\w����CRz����:к�s*-l��}�� 4�'��h�BB�&E�Âw☩�f�p���l�*>��Rl-M��=���Go�X�`�����>�S���K/���:�N����q�n��ۮ�ͦK��Q���H��)/��	��f�C��k���'��5�-6�ސ��A�hN��b�����'��Y�S="�Fnp��9��$2��Y1�����J[��>4�X���Bs�I�#��WǦ_����h5.+Ջm��̒��S�7�D�*�{ӦD�H��R�Qŷf-�`�PϬܖ�@V��09f�0�B�e@��](������\5���Lv\Z��\7�7��ȋRu֍����@!� ���σ�Ԕ�� �U��9����\д~� }�fih���,h��G�(��ub2������ ��Ҳ�EY`�����.�.�_84�-�1�G�/����7�����d*��e
=�z4h�-a�~&HhvW7�����M���༌�C
���O�弇m���fb /}p��_�$��h6�t�0n���t�D:��^�����tk�q[r^AO_��^�J,���	��c��	��~�ftٹ,�ǐ)��n�0�R��f7��`�fhtX���Z<H�����j�R�Z/�!��$���&a]�ۏ۶�r�����89�(�K49#�\֕�D9і89c �d��"ﰫ�u4��s��|��b��g�	�bL�l�qļ)c�Z`yZ�j��HаySso���Ҫ|��`n��B8@�)����;��2݁�����k@qg�PNȱ`�f���:#�$\��^�ś�~N����~��H��U�ƨ➚��j�6�sH�V�L�����;�L�C~�ϟ,��ۆ�P�"�r�L�}^�~�ʌCe�8��p��I$�/1�Q���K$��Ƃ
<x3��\����~e���@�E6���d �� Ef�i/L4���f�l�ND�G4v�*Wa�C:vƍbk��6c ����X����+6�ô�F�H�����ܜC2nԎR
CH{Ay�th[��!~�Ȫ���嵌$bm�7����Ј�6�O�C�4��5�1� ~R����ڨ4����d2��M�7 �M,߹@X��k��CD�@�Ҡ�凖�(�X��uI~�����+�\F�j�ح�cv�7�D��ӥI38ހ��ǟ���? �M�;e1���0��c��0�O�$�Z>��J�[����j@$���R�~qE��ѹ�V�`:����16ϡ%i?���<�.`��O��R��TWJ�1v�!��9$�!��U�ɉ�ݯ�p�x��=���m�L�zƫ< �u�����Fޖ��\�3���&���75�ʕO��Ӌ�g��i��=��1"x����
(2vp64�x#:�t�^W`�t�	W�;���	"�#f���&q_�$ڎ��e4ՊRv�H��+�٭��.��l,�#�ԕ�:1~��A��4S��K@8�5�"��	�5�O�m�;���6����q"���R16��d�,Ӗ�;D�4M��"M���ۥ����o:��@��S�k��qQ\b�3����?^kk��A��;1����y�0�^w�y�1�0�< ;ppH�p2Y�����m_ ��M�hk��C�
����!G�qg�]�S�X��zU^�� ���t��4� �T'�aQ�v�����S)�v��RU�$��7�>)=&�+�7]��t$4O3$ӈ0j0^���y6?�������~��,15Z�쐭)2�f�S2_ .0F�ߙ�@e
�/���-h�=���Y:�ѧG��MD��'�"�m����qD�����HkiE�2�*@L[��Z_/Z���W��iv������~Z��M��$> �Y�JG�"Β�.��Rm�ic�cE�^�z��6����ֵ��X�f;���I��R�����1'�Q8d)�G����@K&�i#�J�sTj%��k��j��Q荘"���֛���gd�5�~upi��x���|W�Xm\Ff�y�P"�lra5��Rv%�_�|��m
��p�n�2ⰠC�ݐ�i	��Tq������k=#ҍ�M�A��|w��s7�kT�\3�1!�.L�<������`*s��
�,�]��M�vq�����0'�,�.��av $�^�Q]ej2fM��G�|Fl*�
X
jlL�F����CnƵ7����j�}�pN;��׋5�҃�2�]W��j����4��d�ڜ����f�����x�ȷ�
V�UX�I~ ��^#���"3&f��Z"���5<�҄�!z�B&cZ��X�`a	f-j����G!�8	sDW�F��u��'�H
��`*Jo�h�Ev�f�X�y#!v��'�P�	a3��`��s�w�1�'ۏ���\Oee1SC�6]߆�%}ϊܰ���j3���ED|'���3#UN��É��v=������馧E�P5��eQ��.�:(0�@֚u
�n��;$�;����zpO%?�jjxo���Dw�J Kf������:s7�6N�m�ޜ�|]��ݪ�U�H��n�p�l�G���̰H0�̛l�H���ʸ'ԃy���$z8�Bp�+���x�넙�9%�ԩ�EtRI&_5U"�Gc�����ݠ�B(�v�TIܪ�C��@��u�HE �,F�N��ވ9,��͆��B"2���բ!�_[�g�`�����L7�7�Y���L�&�
Y�U��"�w>���M�v�ĕw��9��M�W�vp�v���K�s91�B`��C0��m�r|
s:H�g��)qYQ�����Tk�?���&o�r~�q�7c��I��,��j�㟱xɽ�����ƢB~��O�D���o:`��Ƚ�Ua̉3Ֆ<-0�F6�%^�ЋB�l-�M�p����3��N���0�)ӧM�c��|E����~z��,���''��C�9�f������#��v��0N�T���G�e�aA��c��|u*��]Dw_� �P��g�j�z�X;,��G���% ��S9��(p@Y��Tr��x`�G
Z7�XGJ��}�py��� ���1��D���-v�t�G��	���v��"e��$��<�����1B��RD`��v��A��ς���Z� �X��;)��Y�p��o�#aej���l(5y��g��e(��<<�;�bB ɳv�7���O�Q\Էl�k�}�X~@�|g�-#^��"]��؅�n���*];F2_��f��.�s�����ha���SbA8���IK/�eu��^��.V���u�?�h��n�*��q~���xWIq�xH5)��JRl�45)	"�u�j���^d�AQ�i��}����=+�����i����0�p*H����pV��eI�k�����8����)�dw���n2�ɱ��%�� l]���$k����u��������+Ԟ �������ތ��q6�Nt8��'���w��#t�M����8��U#�G�﯀�.l�ę�5f�����^E�S��-� �ŏ��t���P�b��.����֒8�k�T�Mi�|˹s�~<��K�9w�O���� H����G'������Iֵt�c�;a9�&��卼˚閣��*��-�iѣZJ/�V+9T[��b�������:����e4i��/͸g/�R�O0��{�_P!��%��c�ߓ����;w1�xG&�.I��M�E6��Y�b�(	�u�)��	��+}W�p�n\9���eb��HC�$ա�/��ѵP^f��#z���R�.�ĥ䋯�4�PL�ʃ�MQV{����,��}N9ܧ���x�*�����y��6AL��;<o�jQt7b6\�L1�#�C�ΐ�x��_�a.'2hB�C$ޖ� �O��ߕ+EH����
LV����ph��y����yL�4]�7/��-ݩ<a��ӟXhW�q�z;��`�U�ބ�/�6Q)nԩ.���mD	b����!�in����H�Kg�D�#�urK�*-oi�,o���"`�/�Ί{���ޣ����IPW/��5m���g*���C��vJg��r�坾;��_���#���ي'�&�>�E�����K������h-�xĺ��r�C�ƭ��ʩ�=}*p�O��ñ��GD�Z���,�PD�D�AwԼ}Y�Ԃ�S���M�9�q�k�^������:�V����
�k��:�6�b6< �mO@N���>1M��R��;����,8a��9^KAs���ghx+����M�%�	{��f�QR�`�n	�~7kbf�D���T������ގ���R�'�������������蚴8 �]G�6/�q�c����ϵ%��6/~C�����{�K�)��-_��?�6?���avΜ�t?]Q?o�(��lЄ����X��-�e�Roӊ-0��)��޺�q*�����gn�w�Q,g�����/ms�0�7c;)Hp�8� ��F�Δ�S�ݼ��'~Y�م{��n鰘�L�����#�ﾸ�\ҋ��޺���oQ�Ս�4�T�SѠdȽ�
u2KFc��{��pt�w��57+e���6&�����U��6��.x��y�[_(������y��q���}<��ay.D�q����B=�i%Uc�V���v\Ǣ��rf���A�W��鞴�u��(p��Fܓ�����EƏ�׆ȫbW�V���k=Tn_N��2��v��u5U|�����8U~l�a�Y͖���+����F5cM#`�}�ʞQ��k��QIF:e�F��ه3
���MӴŻ��`i�G�W�^�D[�{;�-��\���5M	T�c꟱�z��A��C���HV$��RQ�6	ݚV�+I�U�R���چ�m�������O���vo�b��]����u���q㢋>"����qL��2û�|�<$v���_�ѓdn�zR^|�L���9�����,�J��}�S�(��aKswh��_��֩�NQtq;x��N�XR�}�]�7Rd��f�T�f�ơ/���=mU�o�E���p���'������";�2��P���5$���2ӑ��yr��5���������!�Ŝ��~ħ���F0�TR'�ڮ�F�l�7��"x��b?6��7��w�
����c��Μ�B/���v��Q�"���0�A�*�֙���{D��ۇ:Qo�Uޢ{� �3h���{�����C@�m*'�J����C*)	���h��{{�7��_�g���~���͋GZ%�s�g۷,��y���O�GW|b��c{	He	�ꛏ2���y ����v+ol�ﰱ�.G
�7`����UM �k�`ö�q,,6ar8�>��ғ2VQ쉢�6�=8��r�F�F�%R���������r�̯��T`G,�c^��bU����K������@!aE�/.Lv`���Y� �Ā_���Tq�BF��ܦ�@���2~�*0�<�͋:@p�Y�Ɯ��bj	(`��H�r�>��E��:U!c&D�[_1θO__��:ȫ��kN5I+��2Wׯ��Z��1��R\*y*a�/,�����~���gZ��_� ���p
���V*2��^�4$%mP�}�S���XHڰr��h%�Z���jsٚEQ�Ĥ�ݍT>�t-$�1@�t�J�~,���4��]޹����B�6��$F������+�f<�)@C�/���p��7�T�4��G�i/�_hm��&�f�K�iC�*�vw��o*ɉ2'�U�G�ĉ�bS����y�� �V���D!�])3����r�⦨u?PF�����Y�$�t1&��A�ﾫ�顩�{I2BAW�kR'��^�#�XF�֥W��������4b��BM�H�let6nR���'�˒�s���6�q��8���.�I@�h[�t��p��q�endstream
endobj
52 0 obj
8186
endobj
57 0 obj
<</Length 58 0 R/Filter /FlateDecode>>
stream
x��=ɎGr0|#�ž=:�����	s����a[|�@�M��I�%��̬��%��cw� �.d��V?^�E^	�W���գ���p���#q�����G?>�i�U�߳WW�Ex�D�Փ������E;w�]��WO^=����7b��	�N_^��`�IZ��O�f��N��Zl�ٞ<����Z,��`�;���&*m��N��p��;o�ӧ��V��G���[a��;؂6����!y'���^�W�N��9�V���q©<wy�Mڕ����5y�2�XsRB��o����pu���UyٯNio���O'U0k<���R&J{zO��߰��v�rB܎
���h
����
mM_:�dt��<�V���L�����q�]���=��!*���H�z�g�7}�g1K���˵�p�X��< �Z�)���Z����v��%��(n���m�u9�3|���^vZ�]�${z^�[,p<m#@�M	���/	^� �S��5쉞��,u��˦��n�U(�V(I0C��H� ?��t����ŎB^G�^b�ӫr���!t���~�����qz�����7؆1��BS尰�s���Z|\�
P�aq����Vȸz�u:��������/N� ry����x��� �I�"ƓE(v�/�_�[�5��@�����a�I_m���y�V�(c@Z*�A�4����|����1�Т}P'lD��I0A7��BG���x�z�A��~��)�f!Т�|��&�	�FJ!�(�����Ք����G�I����gR����D4@n�kX�eHE�F���M��2���NA2 �
f;#Ԕt8kWd�s��>�P���"�6�-H�@���0��p�Y��5^e0G]o�E�+HF*�9��Á�N*�4>V�E�$������
*y�q~QΚ�M�\�H72�&pe�l��_��6pi��t��	Y�	�	�G/4u��Q��rѺ'}�h�U�
h
d�'��f�Z���kyС�����[F�� �)=�b����F�J�c%7)+.;;cV�1��p�^�FI(�8ZQ/M��U�Ud�X~oLKe����w���b�a5�fci7R���X3�#V!�o��7$Y��_]��3+�)�Dk�����Ř�4E1Ҋ]�ЌHQ�J�L��Q_�t��{|l�G}�6� ܔ(�d˛�$jE.��Փ�=z�׿?��O�\Oӆ3l�~C~��֨��{H�@���#zՀ�pR	�^*3�}4�f�� S��TInE��$r�d3�<��[% �A�ԍ�j�x;Z:��O�Mj�Q�v���o*�ڪl�$�湃�S��S!$Q�^�sw���<�zbF��xB����A��zl����'���x�~�J?'�`��x>�湪�I|%;=�;���K�9w��R��,���up��N��9'6iG�.ev I�]����[��]�%&��$�Щ��3"b����wDg}:��7�j��N�S1i���%/�t�f�k�� �������p"�u�_f�d��0b+c�\�o;40�D'y��A����Ќ=����i�D���|j,�����m�!��;-u��ps4�vg&g�R+�øX�CX����Hi��,�ǀ�܀?OO���2Hy�O���ةr	$\�����,#�M�! 1G�4m�e~��q���Wd����yoA�)����ʮ�-�7g�So�f�Ts�,O�HvX*[b�N�dǶ�;:^}�U)���d���ɄcM>��^�LЍ��a����9�b�M���-1OP�dth,���P����y8\�z�Ros��T�!K��&|��%z���M�A܈�Z�j��
�$��=x�םN�;sȆ�[�ݙ]��W�h)�x��))Zr�T��5���4�P�
,���e!�Y�´��a�
d�>X�P�댧�����o
�&Ėy���1��Z��x&t�Q���	L���hJ��J�d���(����-���Y��ị�]6iX�I�j�1�4E%+;���/[ڶ!֊��x_w�ŭ��6�/k�~Ӌ1$3� (�Jw�/�ʷ.�+���d����� gpq5�Cn��	�!A�'�.�=m�X����"Oa�>ǰҊt'�8/.e|\@��F�آg����5�����+=<"/���sd��QQ�"�# 	��j�ɻ?^[F���H��i�r�M�
�n⭓��
��ɜ[���f_�p���*�^�3�i�J$7���R��B�}�4k[)���xjUJ`��h�`m@��'���2�:Z�������YbX����)�s�����r$���LΪ��!��A�$��΍�!]l0�c:�i2	=q�N��-�9u	�kP~�[9��
d��`���Ħo$��"q��B���7�2�5A��@�Op��`���3�f��-zץ�ydN��Y�Kz�B'p��FTQj��\;Ԅ��B�p;�כq�K�-��!`�n�w?U�IL��7��3�&`�躬ݓ�I;���2OC�̈�]0�/w�+_0^�9~����Me���Xل��R���%��w����<v��E+;�s׵ۮ%:�kt��o��W��oй�XJ\���ș���A��©;��N���>�Q��WV1tw&RbtG"sw�j���;�k���Og$܃��eZ�Oj��`h��9O8h�Ox�*�Ec�<�"�!�{�Ku�pv�a��~� �8a��榙@���N�.ͮs���C��5�kZ f������3s���&g� �
�H��]޹�.%��˲:2�
n����q7��k�gS
�ѹ�������& P��O��+��%+�og�O����x,���Tn4�<G�I������潭8y���V'�
�q���B|�Si�S��y��fl��y������>v�9�s���7��������M��I�i�t�q��L����x��Z�!��Q��C]��7�ڐ�)��m�軼�Z�$��ց9:2/'>'�P���(En�4�n"'k%����z�nNs����%s�N�U��g=pӶ��qR����{��]�2h<�Ds�WC��� �T�S/�F_����<@gb�^��M��$��I��*��(��vC�e��[�eǲ�r�A�%����q�
�_7u�!\�D��!Ahs�>F��P���o05D��g�Ιң!l]ku�c��R��n�ٵ�$���������7�y2�%C��%s�J��Ēj��|�� ��[ao�H-�+J��X�+�	i�����/KB��|��8j> �����4W����+n��p!e�1����?H0+M·cz�,j���'�(�ҥĬ���5�5��4�11����@��5	�ҳb�12����t9���"o~�E[�Q�T�ٙ.����s:�;T����f�E����J�$����U*gc��$i*}G�mx�$[i�d,��'�����-�=�PV.~��P�0׮*t��Pf��.uq
&���u�$�P�P��6�˖$P�n��Q�.�3w�
2���mf�u1U�PV�]��$��1s�j�ZM�@���aD��n�)�;��|�j/��A?��/�D��ڎ%C�̄,���dR�Y�e+[/B[r��8�I������96�(U3�*c���T��3ݨ��3l�jC�韠mΩ�	4����W%c��Z�
P~_��S<M?�'��-L����OM��p_�bq��O�j��d?�G��.�r�-��`�.r��hvΑ����F������� �/qJO:,���с4��6obz���.8�["���}�f\(�X7el����o����+���6��9�5�.d�8����ΐ<�	7����
�������A�C)^���M��f��Ɍ�F?/�v��݊��'�t6�B.!�O�=����0e�i��t�M�`�uY`���.l(��X��/jk� �T��U5Z�og������n�Ic����Z�Q�Rs5$�N��5<�(�T>����;�5O+d�O|6֌O��s7�,͢�!�,�L����Y3TI[�
5�0�Yf�X>��t�
iW&��}��IK,������30&�1�3�j�B���/0袀�O�#���6E��F�1(/�V=���Hn6�O�J�i@�}mZ��	H|c��2�T#�j"\�yb�_'�4�N_g:�$	� AR;I�`��S�/b+�J�;`���Z[���B�8�#C­h'7�Di�I��I��Nr9u?X�>�ܑ�D�[�>�A��)���L�&c�M���jF�+W�b5���W1����WCe`/s�*�H��]�e{N\�N%�m����jm�t�=�a�������v>x�.�=T޲�f]��n�Z�s�yY�i�Fbc�	�buXX��?����/���aG5��D�+�9k�V����!j�	�Er�qWoNܶ帺��+��#�E	�V�ɐ���R��w��>6�ldI��]�=�@����_�A�>p�������$����"�~s���q��L�A'o^c���ug���N�8ٛA�T��|9}Ro8�j�i��ƨظ���}*�ۼ�Pe��[�#�b��j��	��Y:�p�m���z�f�A}�%�_6�ӿ��^a	���݀�-K��2�D+��� ���$3G�$R���F3�n����Y#]� ��#H�ԓ	[�U.��)6}|Ch� �o���3^=КTR���ҷ�k]�k5�G�p8*�5�}����v? �O�p�ޒ�cAP�N��3�}��-��3jxe�����x)�ؤ ���.��J�u��J�tl��1�
f(�1u��T�{O�v���8WS*��ķ|yь���%�e��)+f�6hXg�:��t�c.�Q����q���)�~�s��PK0����Z��CL};�;�|��E,]$�`�T8\�0�޹[؝���k^�lgԪ)��O	�;Ԛ�=S�Q\S��a�7�Qڪ�Zr��i�c-V�[�8���٠eKɞ7m�\<p
���O�I���70l�Fӏ�Σ���]	����mrd�C��IH�t���#%;U�i���� ��_��ydU�H�zq%t_��"T��4�k<��y=�[����UQ\�������ι����y~�+]�8p2{&Y�b��(2����.|��K��[�N]w+��I���#gb���[��A�tY-lj���7���K~�B[��谥�nT�lu�]�C�)��:�\NT�'	2"�0�}�Ū�_��Q��M����-�ܦ�p���V�&�k��Db;�8����� j�o��w�>M��L7�� tc�̈́` &�1!$��2LP��?�	�t�;�i��V�7�%v?����挠�N|m�@�Z�L���8QM�PMe��6.m$Ft+��1	8"W�S�ɍ뺃�)F�.�PͺF)���cu���~'.W�x��ʚJ�~мO�y�B�d���&�%�?r')km�'
+{=���M`Ś4m���0.����;Wol�W�����jҲ3r<���$�R�N��\*��>��U�`�n��q�g�M��i��vl�|�c�o�����g)�7#{q�r���|$����YC~�y��f_���c0~R0�8�4HL��5�@	��ȱ�O�`e�s�)ְ7���FRV�����E:�J=Nrge(��4��ީ�ֻ�8{l8�J\&�
���|����羡&gZ�|�t���y�=Tb>g����y�φ���1q�L�� �D<]k��=��6U(���w� �qW�K��զq��L~��)D�����:��3|�\K��8b7�]�����X���0��#^��A��eI�Y�09Iӓ�q(/�~e[F�WI$NE��{��ƍ��q�!��� �/�S.fc���ƨZ:���D�l��M84��=khwN�.�����Ck�& �����؄%Z���ms#r�~�d �l���j�&�I�^��*�s���*�ob^$J��ѣv�ɤt�S�e]w2��&���fj�^[���CV?��O�(�W��%�&�(8��	���jj��,� �kC-�)ka�f�;8�C>4��26)J���Fm�t-LӮ����ظ�'���*L��!B_�08[T��g�g
[�����3]��w��q���wy�}$ƹf���E����6��lE8�[���1�|�ٝ$�K�tE4�&pL�SPlT
6զ�/[d�͡.UueH���CS�k�~l��[{�l��U��QZ���n~p$T5q�g ;q�Y���x��ֺ��l �ߥ�I[1��V)O)�|7�fY�I��%||�,ܸ`�r"����W�o�$S�\���;�=%S�"<궶���_�}U)���f'�J�6�e�d�_�rv���f}hZ�`%���~��f����s6�V5s�S�>ǍgR���t�! �v ��!�������R�0����r��uDIߗ*TE!��yd�G�Rcwΰ7�i���G�ΊUW3��ºF{��WRwg5[pF+���ϕ*J{h��b���6X���:�a��I��l\��~w�Ϳ��MU-3��)L�\`�L�M��p6�U(�5��*
�$�����6�V>�᫱f�F��r�x@�8C��H-�x3��B6���J|c�J��M�<�okz�dtF8���b������M�읈Yf�M-���:�2I6M��ġ[G+�����6k9D����Li�Ϫt�/�4/٪��[o�7�P�߿���<)'�at� N]����Pi���X��Z��� #Ռ��'�O�Qk�u9L�0��OL��wG��*b�G�yQ��׀ʰ�ZR%fίjc�Eu5�/�
0��ň5��\N�
�.��'6��m�M�_�KG��Ɵ2�L����N
��5߇���"�����N?�$LM8�&�8̭�x�!�j��q��?$x�qw�-c�K�x��� *WJ[3܈�(R <�n�n�.��n!�f�
j�oM�	�iW2��Jי�o�{FG֛C\2g���FJ嬪�1҂��V9��z�A�q�N���.�Qrʢ�.����*e��B��6*�Lv/�wn1	,�E�X؂����������ҶZzendstream
endobj
58 0 obj
7172
endobj
62 0 obj
<</Length 63 0 R/Filter /FlateDecode>>
stream
x��][��q��F�oX��l�3���A`Ć� ��8"V����\R�I��wUu�L�m��]R�!x5����}u9?^�E^
�_���.����w����ϋ�/$�������o� �(��|��EzY^z�h�.������髋?~{u��NHu��ꨃYdPi���>�w�I>�j�f{z/�ەX���*wx������W8����߷���68}��J���Go�Q�?��YT���I+���b�*+��VXo�o�Si���Z����{�"m�XsPB�ᾏ���U�<j�gU������4�7B��;�[[�L�X���j1Q�m����z��
>6,&x�����^�ђ��"�2��CZ��v89]G�'b<s����t~q��o���R/^���Wx���pC�W�W[�K�{��P�t�p����Էc#�a�:c`���WA-'knޤLu2?�G���x]��
!�������u�ן��9�3Fz�Oo:��k8$�ʾc|p=�:( {z�oJ:[]���e)�&��#�&�_)�� r�<��Cp��'��7��r�U���Ӥ3�sW�F���!�����.�@ZxE�i�� <�=;:��w�N�r^^G]�M4�U���W���~&ƍA�8b��D����(����I|�I.J�������{z�G�Ya/��"hl�.���Wۓ�PL^���f�*�]�A0	S:جL��.A���x	`K0D��sD�\�"��\�[D�!��'�_��(|递Qm+B���׽�[Q#(��>5�#X�!m�q�*�Z�K��i�V��º�%n���g���f�����Z�o����-"p� ��zal��'¤��E�S4��S�w�F����]�zitYW*�q�PN�L���j�t���,0'�J%�<�
�mh�yT��H�#rl ��ߨ�ԋ$܀R�"|IXs�z�43S�L�q�=�iC�ڐS�]S6��ʢ%m��L-�w���_�O_�������Ny������TB8�0��&�IF4���^y2oWj���s��fz���fO�0�Py4�Ce�����i�	���3����!>�f6N���=�S��x�,�<��&��	���v�'�M��<�MCY�YЪ,./��/�� �b�J)VSد�:"Z�D_(;��:J&nZ헷�P���j���`AR�=�2g��h	R�>��N��hD\�	�Ўذ��B9���.\��'N� ���&7���,B�B4��v�8o�f���6M�������M�(,���wi|˒3�ǂ��(�ٱ���^���#m�M��g�M0RV߇�Oā�+0J�@?VJL��I�^�Zg	7�Z�U�X�P��`�ýT��zW{rdg�5蚫*��W#�ҫ�wĨ*��U�Y�jNQ6��_� ��1U�{�J��Y��=����S����,����d���(���-j�q��'���C���L8��Ao�Ա���:6]��>��S�+�m��t�@5�dh��Ҭ �-;c� A�*�����:2��9K�6�~�O#�t״K4:O��ȹ����O��¢�;��-��e�;f��]E5~1�����|�D���2��y��i7:=&�E��nӛ�sM���ݧ���ݗ��q���Qo���f]Ѐ ��YFV�Y�j���؎�S��.�!Rϐ��#��0��	|��������"I]p�N�/��Q?P������%��wiyA���6ҋ)���h��dm�S����r��.+��[F�n{��(�~?�5 0i����9q�b�N�+�k`�=P��Wt�:X��8�/��F�Z�d��O��p8*�W���3qeg;���5�:�.���A��8|������l��'���E�VƎ�8B>��'�%�(45�����>*U�8�@9�s�Y����T��ɉ�����w�#����PW+�Qp�z��gyC�2)�v�ƅ[�� 8��&�;2�	��8����?��`��:��-8����{�&<����U�u}�񈘝�n��P���x�
p�A=�<~���nj�L�C]j��	�J~�N��;��*��A2,�YD���L��8�(��!���Kԝq�Rf��mDM�h��flǄ�,��g���Y��W����*>Q#^\��Ps�h��Y�Wl;��Nf�Z���Ӻ����FPt���h�CY��u$Ы�����j�!P\��*�B���M�4�4~.th��B�N���i��rS���:��	�$�����p�C-D���-�1�{�Ӧ
���fʏ�:#���2\���s���y�c�C�ހ����U3���O9s�+ȿ�yT�X��V����Vg�1.	;��F�?_ϓY�0�a���M �|�y�!��ہZ���p����UРz1�B��:�E)3iN�h|���hw�痽�~ب�U�C�W��|O�C��+�O8�����,��6J�>>5~1,Q�(H�$��ի�o~#�$3Z���*į�L�V�M.6��"�D�sT�����f"M2���g|�������=_<'���tU��O�=)N�e�r�a
�	�!��ջPt�$i7Zֶgޯvʶ��[S;6mݵ60.Uk?�#-8�����M�V���o_���>�ӄΏ���,nx��,���6�N�$����Bd}ߵ����u��ǘ��D��n��0&�~t���ŝ�,jNXc�3���� !�ke���-�h�Zi�A���R��fd��E�P1R�ju����)��ز�ߏU�����V��l���:T�e�"N��.���m���e�`��e�;���~��Z;�upԊ#���y�2����:��;�'�5W���Z�f����^)��Fg�ey�����S�Y�B�[���y�s]��c�NF�rS|hdb�b�5�/���R����R�y-���Aα�ȳ��+E|.���X�1����Q
4x�6^_����7�Z��3{��Z&`�5܍��)�]?�X��.%���טN���"��tX�`1)��z�G�����١\L��2�=��RE�ŴEϒ4:�MѸM�����"3����7ߦI�3g�%8�r#_��p��h(��̘?v~�R<#�6x�y,e1�}���%�-^e�M޺��&1��ŭ2�j5��:������|�m�n��mN
�V���Wl%<�6%��d�x6��se����̴Aih4�n� ܓ���`��ݓ��?�=1Sa�8�~.�������@$'����n��1�`Q賌����ܔ}n�'}�@�N�;<�-�K/"��Z��܈HN�ٟ�B�3�%f�w�]���k��7�M����h� nh��r�����bpM]����\��l&�Se�-7��r�\�z��J%�ٺ����b�kD��:ek��S�����w�?�
=FY�pC'�.-��֔���>�i+��2�4׌�pS�Z���t{Ncq��a�*l�[��*���6�QN�g�U��� �qRt>����r�V|��X���0hPp���ܡ����s��y���_T�sJ�x^3X����D8��Pˍ/<)S@��Ng#M?��O��鬌n.>>E��VGl�˨�wТtQ*|g�ĕ$�뉻n1���5o%�毲�pj&���,���N>�, �M�a�����{��n�"}1Ni� �>�B�>}��a�+��7S�w�����?7����&:�+a�?�b����@7���v	+5�a�h]��Nd77:�����P�h�;8����L�"��o��1]|j_OL�,DI��3�tQƷ ����<Zj�<គ�]���ytf������IN����l���tu��)<*җh���B}��W�a��4 ��'L7	��O+��T���;pf%�O;Q�J	�H5NC[��{��D�*��ZQĳX�SnTl��b�~���Y3����ٲ>�mn=�,y����A&�u^���sF2CsC�"ζ*�ZX��r"Ѕ]\������Lxݭ�I�|��y�^�u��nZ}�|>�^��L�6��sD�U��Bc/�ώ����	Fn,,�B<s�lM�;i�Rm�~���Du=ǏCs����):��WLؐ��Z:�\�98B>��*�3�R�e�R��˃]���W3rL�,�dz�s��|���O���+�d�aw����:ͫ��u���s��Ƴmg pfo��65���|�:}_�8e�I��dk��>η�,%�)�n�MPC;k'�q�|��쩀��$�U-�1�;D��	I�a��Dg�J�QA#jTh�Ur���"�P�_��3���-`��&u"��{R}��0�Pˑpj�{��κ��D��ij�k>'�����l4�D�Zq=8续`ClU!�	����G�g�	�J��z���iG���~���x��a�0`۷"b�q�%U�9����ތgt��� .�p���X�=+�(5�nJ�x���Ovb�6F#�^l�)M�ÃмHy'��`8��P�j���r��)V�#���,ZXD���k#1�ON��:���-(�	�#�ʖe�s�-���cI��v�5_�y8��2�!�::�=q[Z����x"��x'�K��3��.�dJ�l!ŉ���
��C��I	,e�o��Q�)L���2�Y]�@�t�ά�I���+��h�
<�y���ͱq��Az�,5�Y�M�C�h+�r�fq>ݢx�[4i`����wx�ߦ�@����:ܫ�Iw��Uf}�ؐ�iYB���/�u�FլVK�jԔ_w�fI`�׊7G����bmy�ڼr�6yDf���	XR�׾�V�@୴?��YQhI�W���ĿS?���3����t�1y��yB˰
JT5��uH��0��K��MC�rK�#W�y$7$��������2�J]� ,F*�ӫ��b��z���्�C�f�����'%е/��y�,7�Fo�H��y q]��-uZ�����U|g;:v5*<O[�'��ǡM�w�g��(@
^8�n�t��`V��	�n��t�~5_+�]�.��а���<b���'��`sW!%m�.uO�� U� �9�S�J`+W�	T'SF{KU[.���0Y%z����!��]7���\�5��ϋ����N��˹���u"J;���AU��4@65v� @9^��t�UǑN�Jt<���"��(�Aw��sD-l�<��XTWg���'��OAŮ��~\#�����k{V���Q�0L�Դ+x��-�J(Ǆɻr���>���Ys�M��F��L�	�l�^9=&�sֱ������t����s����Y'��#�����:�}���1s��oj���ȋd��:Ǉ���﷓��?ք�4�:�M���%�V�n�̎�ɋ
�W�LI�����'�ES����&��/a�gRѻ�yD�=��c�[!���V[ Vn+��M��)�e��i�7'2�
�ûXs&7l�y	��j?᪀�B%g58��ZנÔ^�y:��f!��m��1��ߦl��#F�떅!<GV6���1yI8�5�Aƾ��G1�8�W�&��dAٌ�{p��ٶ�Bx������GM���T��󠰡�\hn�>N_3����)�
��-;i�͵�lP�D;�����@��>H){J��D�?Q�LW�Td�FޖQ��Vu��q��I��P�����٭���	��Ÿ!:;���q�ͺV�����&$0D���p���F��{��,�A})��}�R#���TȬ��Y�[.t���;�X�����Ûh��Pm�������&e����苝��>}}+��;���?�u-����Ko�^�T������'��Zub����Ȃ�;��Iנ��Tf�����m�"�9�֮�I��2��Y[��r�#�)��-x�MiD}�g�g5�m�KԃPM�����ip�����S_��4�D��#��<�������\4����n݅=gA��A�=���h�
�E����6yj�vy8�h����ǆi��\���1N�Z��h!]U"Y{�D2��錳�����N�Z�E��C��5h��5�����7�����<�}�G鍷���*$k�"9K9-c�1N��崭�DAn{<�^���Az� �m�I��
�J�L+��-�g��/��]��#W�8��a��i{�����j��`�6W��5�[q�����ws�����]�xBuX�V�4Fߧ��p^Z ���_��Zk�	GA�WF�6CA�Q&Z���mzUo��SުF�~m�����櫾LCCT�C��pV�z�;�I̽���ѫ@�K[�kt�ҫKeq�����(�v�	�H �#'u8�~v�oS�-��ӛb?%oX8ǋjp�f�+��VZ+�[q����?W�C���t���:�J�S����;I8kl�T���{�1�urX0ND��g��0�6�Tױ�H�?�_��ݯBׂ��k���t���p��UZW��U6�	�?j|n����[��h
RM�i�SQ	ܪ�y��/25�rk]E�g� c*��Ged*3A �$tz�~��3�����S��ߦc�R���r�uJ����5�U�ҩ4��	���kM�wׯ�q�Bq����\f��Tr��G�%f-\�,�_��/��?��ǋ�s�%	endstream
endobj
63 0 obj
6677
endobj
4 0 obj
<</Type/Page/MediaBox [0 0 612 792]
/Rotate 0/Parent 3 0 R
/Resources<</ProcSet[/PDF /Text]
/ExtGState 40 0 R
/Font 41 0 R
>>
/Contents 6 0 R
>>
endobj
42 0 obj
<</Type/Page/MediaBox [0 0 612 792]
/Rotate 0/Parent 3 0 R
/Resources<</ProcSet[/PDF /Text]
/ExtGState 48 0 R
/Font 49 0 R
>>
/Annots[47 0 R]/Contents 43 0 R
>>
endobj
50 0 obj
<</Type/Page/MediaBox [0 0 612 792]
/Rotate 0/Parent 3 0 R
/Resources<</ProcSet[/PDF /Text]
/ExtGState 54 0 R
/Font 55 0 R
>>
/Annots[53 0 R]/Contents 51 0 R
>>
endobj
56 0 obj
<</Type/Page/MediaBox [0 0 612 792]
/Rotate 0/Parent 3 0 R
/Resources<</ProcSet[/PDF /Text]
/ExtGState 59 0 R
/Font 60 0 R
>>
/Contents 57 0 R
>>
endobj
61 0 obj
<</Type/Page/MediaBox [0 0 612 792]
/Rotate 0/Parent 3 0 R
/Resources<</ProcSet[/PDF /Text]
/ExtGState 64 0 R
/Font 65 0 R
>>
/Contents 62 0 R
>>
endobj
3 0 obj
<< /Type /Pages /Kids [
4 0 R
42 0 R
50 0 R
56 0 R
61 0 R
] /Count 5
>>
endobj
11 0 obj
<< /Count 6 /First 12 0 R /Last 17 0 R >>
endobj
1 0 obj
<</Type /Catalog /Pages 3 0 R
/Outlines 11 0 R
/Dests 5 0 R
/OpenAction [4 0 R /Fit]
/PageMode/UseOutlines
/Metadata 88 0 R
>>
endobj
8 0 obj
<</Type/ExtGState
/OPM 1>>endobj
12 0 obj
<< /Title()
/Dest/subsection.0.1
/Parent 11 0 R
/Next 13 0 R
>>
endobj
13 0 obj
<< /Title()
/Dest/subsection.0.2
/Parent 11 0 R
/Prev 12 0 R
/Next 14 0 R
>>
endobj
14 0 obj
<< /Title()
/Dest/subsection.0.3
/Parent 11 0 R
/Prev 13 0 R
/Next 15 0 R
>>
endobj
15 0 obj
<< /Title()
/Dest/subsection.0.4
/Parent 11 0 R
/Prev 14 0 R
/Next 16 0 R
>>
endobj
16 0 obj
<< /Title()
/Dest/subsection.0.5
/Parent 11 0 R
/Prev 15 0 R
/Next 17 0 R
>>
endobj
40 0 obj
<</R8
8 0 R>>
endobj
41 0 obj
<</R38
38 0 R/R36
36 0 R/R34
34 0 R/R32
32 0 R/R30
30 0 R/R28
28 0 R/R26
26 0 R/R24
24 0 R/R22
22 0 R/R20
20 0 R/R18
18 0 R/R9
9 0 R>>
endobj
47 0 obj
<</Type/Annot
/H/I
/Border [0 0 1]
/C [0 1 1]
/Rect [118.146 68.3127 372.138 80.3043]
/A<</S/URI
/URI(http://en.wikipedia.org/wiki/Convex_function)>>
/Subtype/Link>>endobj
48 0 obj
<</R8
8 0 R>>
endobj
49 0 obj
<</R45
45 0 R/R36
36 0 R/R34
34 0 R/R32
32 0 R/R30
30 0 R/R28
28 0 R/R26
26 0 R/R20
20 0 R/R18
18 0 R/R9
9 0 R>>
endobj
53 0 obj
<</Type/Annot
/H/I
/Border [0 0 1]
/C [0 1 1]
/Rect [102.243 606.666 390.606 618.657]
/A<</S/URI
/URI(http://en.wikipedia.org/wiki/Golden_section_search)>>
/Subtype/Link>>endobj
54 0 obj
<</R8
8 0 R>>
endobj
55 0 obj
<</R45
45 0 R/R38
38 0 R/R36
36 0 R/R34
34 0 R/R32
32 0 R/R30
30 0 R/R28
28 0 R/R26
26 0 R/R18
18 0 R/R9
9 0 R>>
endobj
59 0 obj
<</R8
8 0 R>>
endobj
60 0 obj
<</R45
45 0 R/R38
38 0 R/R34
34 0 R/R32
32 0 R/R30
30 0 R/R28
28 0 R/R20
20 0 R/R18
18 0 R/R9
9 0 R>>
endobj
64 0 obj
<</R8
8 0 R>>
endobj
65 0 obj
<</R36
36 0 R/R34
34 0 R/R30
30 0 R/R28
28 0 R/R20
20 0 R/R18
18 0 R/R9
9 0 R>>
endobj
45 0 obj
<</BaseFont/YKLZAR+CMSY8/FontDescriptor 46 0 R/Type/Font
/FirstChar 3/LastChar 112/Widths[ 531 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 708 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
885]
/Encoding 79 0 R/Subtype/Type1>>
endobj
79 0 obj
<</Type/Encoding/BaseEncoding/WinAnsiEncoding/Differences[
3/asteriskmath
50/element
112/radical]>>
endobj
38 0 obj
<</BaseFont/WZVREW+CMR8/FontDescriptor 39 0 R/Type/Font
/FirstChar 43/LastChar 61/Widths[ 826 0 0 0 0
0 531 531 531 531 531 0 0 0 0 0 0 0 826]
/Encoding/WinAnsiEncoding/Subtype/Type1>>
endobj
80 0 obj
<</Filter/FlateDecode/Length 186>>stream
x�]�9� E{N��ɑ,�q�(Jr�Ea@�}��"#�y���m��c�t���c��p���q�3,J���Bq_��|e�����k��9�ȫ��s76�88�@C�2E���u��fyV�-*{ �PK��^^3�hр��.�h@sZv��{���͘�΁��ir(�gXcc� �_bp
endstream
endobj
36 0 obj
<</BaseFont/OTJKIB+CMEX10/FontDescriptor 37 0 R/ToUnicode 80 0 R/Type/Font
/FirstChar 50/LastChar 101/Widths[ 666 666 666 666 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
1055 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 555]
/Encoding 81 0 R/Subtype/Type1>>
endobj
81 0 obj
<</Type/Encoding/BaseEncoding/WinAnsiEncoding/Differences[
50/bracketlefttp/bracketrighttp/bracketleftbt/bracketrightbt
80/summationtext
101/tildewide]>>
endobj
34 0 obj
<</BaseFont/FVRTBC+CMSY10/FontDescriptor 35 0 R/Type/Font
/FirstChar 0/LastChar 106/Widths[
777 277 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 777 777 0 0 0 0 777 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 666 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 500 500 0 0 277]
/Encoding 82 0 R/Subtype/Type1>>
endobj
82 0 obj
<</Type/Encoding/BaseEncoding/WinAnsiEncoding/Differences[
0/minus/periodcentered
20/lessequal/greaterequal
26/propersubset
50/element
102/braceleft/braceright
106/bar]>>
endobj
32 0 obj
<</BaseFont/EKSDVQ+CMMI8/FontDescriptor 33 0 R/Type/Font
/FirstChar 30/LastChar 121/Widths[ 631 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 757 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 618 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 361 0 0 0 939 644 0
0 0 0 0 0 0 0 0 598 525]
/Encoding 83 0 R/Subtype/Type1>>
endobj
83 0 obj
<</Type/Encoding/BaseEncoding/WinAnsiEncoding/Differences[
30/phi]>>
endobj
84 0 obj
<</Filter/FlateDecode/Length 254>>stream
x�]�An� E���8ة�J�l�M����x�F�Y���O�V��5��l~s��/ή�����U��M���#�#_����5��A�M{ќ޴���,����7n>{�{�2��k�A�+��..:�q�`7�{���5��g*�x�����'b*ڙ��T��F�ښ�m��&�W�U����P��V�z��r�
��5��c�аKf��Xᷫ`01��F�ե�MI�`�y��nE��+�d����S�����3�
endstream
endobj
30 0 obj
<</BaseFont/HWRRST+CMMI10/FontDescriptor 31 0 R/ToUnicode 84 0 R/Type/Font
/FirstChar 15/LastChar 121/Widths[ 405
0 0 0 0 0 583 0 0 0 0 0 0 0 0 595 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 277 277 777 0 777 0
0 750 0 714 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 429 0 0 0 489 476 0 344 411 0 0 878 600 0
503 446 451 468 0 572 0 0 571 490]
/Encoding 85 0 R/Subtype/Type1>>
endobj
85 0 obj
<</Type/Encoding/BaseEncoding/WinAnsiEncoding/Differences[
15/epsilon1
21/lambda
30/phi
58/period/comma]>>
endobj
28 0 obj
<</BaseFont/IFSIWU+CMTI10/FontDescriptor 29 0 R/Type/Font
/FirstChar 11/LastChar 122/Widths[ 613 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 357 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 743 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 511 460 460 511 460 306 460 511 306 0 0 255 817 562 511
511 460 421 408 332 536 460 664 463 485 408]
/Encoding 86 0 R/Subtype/Type1>>
endobj
86 0 obj
<</Type/Encoding/BaseEncoding/WinAnsiEncoding/Differences[
11/ff]>>
endobj
26 0 obj
<</BaseFont/WCHBWX+CMTT10/FontDescriptor 27 0 R/Type/Font
/FirstChar 40/LastChar 121/Widths[ 525 525 525 525 525 525 525 525
525 525 525 0 0 525 525 525 525 0 525 0 0 525 0 0
0 0 0 525 0 0 0 525 0 0 0 0 525 525 0 0
0 0 525 0 0 0 0 0 0 0 0 0 0 0 0 525
0 525 0 525 525 525 525 525 525 525 0 525 525 0 525 525
525 0 525 525 525 525 525 525 525 525]
/Encoding/WinAnsiEncoding/Subtype/Type1>>
endobj
24 0 obj
<</BaseFont/IWPQEB+CMCSC10/FontDescriptor 25 0 R/Type/Font
/FirstChar 109/LastChar 112/Widths[ 746 0 0
557]
/Encoding/WinAnsiEncoding/Subtype/Type1>>
endobj
22 0 obj
<</BaseFont/TLDNYO+CMR12/FontDescriptor 23 0 R/Type/Font
/FirstChar 44/LastChar 117/Widths[ 271 0 0 0
489 489 489 489 0 489 0 489 0 489 271 0 0 0 0 0
0 734 0 0 747 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 435 0 0 0 0 0 0 0 0 0 0
543 0 380 0 0 543]
/Encoding/WinAnsiEncoding/Subtype/Type1>>
endobj
20 0 obj
<</BaseFont/VJMNVZ+CMBX12/FontDescriptor 21 0 R/Type/Font
/FirstChar 49/LastChar 121/Widths[ 562 562 562 562 562 562 0 562 0 312 0 0 0 0 0
0 0 0 0 862 0 0 0 879 0 0 0 0 0 0 0
768 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 546 625 0 0 513 0 0 0 312 0 593 312 937 0 562
0 0 459 0 437 625 0 812 0 593]
/Encoding/WinAnsiEncoding/Subtype/Type1>>
endobj
18 0 obj
<</BaseFont/CJFXQT+CMR10/FontDescriptor 19 0 R/Type/Font
/FirstChar 11/LastChar 124/Widths[ 583 555 0 833 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 277 500 0 500 833 0 277 388 388 0 777 277 333 277 0
500 500 500 500 500 500 500 500 500 500 277 277 0 777 0 472
0 750 708 722 763 680 652 784 750 361 513 0 625 916 750 777
680 0 736 555 722 0 750 1027 0 750 0 277 500 277 0 0
0 500 555 444 555 444 305 500 555 277 305 527 277 833 555 500
555 527 391 394 388 555 527 722 527 527 444 0 1000]
/Encoding 87 0 R/Subtype/Type1>>
endobj
87 0 obj
<</Type/Encoding/BaseEncoding/WinAnsiEncoding/Differences[
11/ff/fi
14/ffi
34/quotedblright
39/quoteright
92/quotedblleft
124/emdash]>>
endobj
9 0 obj
<</BaseFont/MWUDWX+CMBX10/FontDescriptor 10 0 R/Type/Font
/FirstChar 48/LastChar 121/Widths[
575 575 575 575 0 575 0 575 0 0 319 0 0 0 0 0
0 0 0 830 0 0 0 0 900 0 0 0 0 0 900 0
0 0 0 638 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 527 0 575 0 319 0 0 0 0 638 575
638 0 473 0 447 0 606 0 606 606]
/Encoding/WinAnsiEncoding/Subtype/Type1>>
endobj
46 0 obj
<</Type/FontDescriptor/FontName/YKLZAR+CMSY8/FontBBox[0 -955 908 564]/Flags 4
/Ascent 564
/CapHeight 564
/Descent -955
/ItalicAngle 0
/StemV 136
/MissingWidth 500
/CharSet(/asteriskmath/element/radical)/FontFile3 66 0 R>>
endobj
66 0 obj
<</Filter/FlateDecode
/Subtype/Type1C/Length 621>>stream
x�MO�kQ��mӭ�X��Ə��4����hDR�m���k�&a�uڬM�4�>�IM�I���J�^O�ē ���ͫդ~�c�9��( ��=0��R����q��8K���*4>5!3�̍Ɵ�X9���Xl�L ��QM/������H�c�{\��N�����^�r>8�I^च����Q//�`G�G����dY��`�_��pB�+y��ŧ����I�.'��^��w����ċp�?Ƌ>.X����3��O��zEQ4���"@���P����`�P-�˝u�T�ُ�уٶl\Ci��յHj慽�Up�Q�|`3�Z6��K���L.�&��9Gw$K�>d���f�5��XE�T4���a%4�'V��'�f�ˤ�>S��15W#(ʄ
J1�D��6��}�\h�K�|��-�׋9[bG}��a,{�T�B���w���m���9����C�<�cf;�]��3�~�N �A��<���v����2'"̮�팥�r0�^)�/{_i����6r�`���&��bd��&��f�L<˦�H����J)���l(�tTBZ:S4��6S@I�br�eEIĔ9�%��wm�Dl��ʑ��ʪ�\�1��Ķ�
endstream
endobj
39 0 obj
<</Type/FontDescriptor/FontName/WZVREW+CMR8/FontBBox[0 -104 766 675]/Flags 65568
/Ascent 675
/CapHeight 675
/Descent -104
/ItalicAngle 0
/StemV 114
/MissingWidth 500
/CharSet(/equal/five/four/one/plus/three/two)/FontFile3 67 0 R>>
endobj
67 0 obj
<</Filter/FlateDecode
/Subtype/Type1C/Length 970>>stream
x��}Lu��8zwcW�f�����0@MA@Q�4,2"��Z��J�P
2��T66X˖Ҏ7Y��e8�������N6�u�d���$O�'����y����$�qEq�m+�&q#.>�$>B@F�PB� %���ّ��*Ty*[�8n~���jsٍ��߬��g��j�|NVV.��Yo7��T+�f� 7&�5�Ψ\��|� ��nu:��ZsC��^[�E�;���ߥo����|��"�;�f=�rY�J*��mAo�K��z��0��g�}2;�)c���)�t�~����J�?��r����7M�z0&����˄�&62a�il�����tqY��C��Q5޶V�#]0+G,z�(3bU���݋=J�
fY!�d����D%#�Y��ǐ�&�xq�9z���)��*�K�w_`�����[�<��U���ڻ}���\�4M���������M|���p��c�]UP5��ַ��:S9��L
���	�H��ظ��U߾'��,D!ս��:Dk�J)o6�\Zb�N��i|.�����L(�h�p��![@�����	��犢"[��rBVd����4�>��M�v�d�i2�����h�BD��f�i�r;��9$w��(D��*�d�3��g�@�	3�봱{u�j��a����Gd5k�#'��s9n��*	����s+V?��K��KH��@���?4�~;;w~���'�H*I���S�ɾ��Xh�
𰣗�� ��L�&��B)EJ�ti��|`� r�(zIa"�Ύ
O�����TB�Ҿ�4q������/D7��3e�I�j�_/
�5pFc'�h����N}��hí����?�F�~������>���f�yh,�::٩sWǁ�wlzѢu7sf���y����V�}��i�bqY���������ײ)ɚ�r�H�R�W�b�����
endstream
endobj
37 0 obj
<</Type/FontDescriptor/FontName/OTJKIB+CMEX10/FontBBox[0 -1760 999 722]/Flags 4
/Ascent 722
/CapHeight 722
/Descent -1760
/ItalicAngle 0
/StemV 149
/MissingWidth 500
/CharSet(/bracketleftbt/bracketlefttp/bracketrightbt/bracketrighttp/summationtext/tildewide)/FontFile3 68 0 R>>
endobj
68 0 obj
<</Filter/FlateDecode
/Subtype/Type1C/Length 600>>stream
x�U��KSQ��q�Lm�)M;B���e��H��,�Bz�q�F�����f������7f�e�B,$�|����|�����k��I勇�|�>_��y 0� ������Ҽ��C�^�՘���7�
�Rf51��u��A�r����w�A9�b|(=9��U��	)����׀[��Ӎ���ى�"�|�v{h�j@_}!B��l��虦&Y�!�����X� �&1"�%~�#wy��ŧC�qJ$��D�x%��6��)h���
��?i�4�B�=JCa?�C~ @'�ZO^% � ��p��1`1N��(��`|����ʂøҤͫ�O�&>e�M�[,z����שv����l���ycƅv��}��G�\Q��n��^g�yUW�ÿ��}u�&5��M盗R�ؓ��{Y[XCy>R*!�¥�S��Ǯ�~��m�C��֞Ό���j6�~�ѿi�UF1�Zӯ�M�6������R�#�ڲ�s��"dڲI{o������|,��%��������?�������+o?���M.ȳɹd�M���Ƴ���ė�U�r��DֲT�����年�j�^ � �x�
endstream
endobj
35 0 obj
<</Type/FontDescriptor/FontName/FVRTBC+CMSY10/FontBBox[0 -250 694 750]/Flags 4
/Ascent 750
/CapHeight 750
/Descent -250
/ItalicAngle 0
/StemV 104
/MissingWidth 500
/CharSet(/bar/braceleft/braceright/element/greaterequal/lessequal/minus/periodcentered/propersubset)/FontFile3 69 0 R>>
endobj
69 0 obj
<</Filter/FlateDecode
/Subtype/Type1C/Length 942>>stream
x�u�mh[U��m�䶋�3�nK�>�VYV��2,�0�ZQ뇭[1�M��.�&1q�,I�4O^����.�23ګ�h�7�(�"*�A��qnv�x�06Q9�sx�����iJ�G�4����>�����|���ɇ���W;�~�(@��������gQ�i�RӴ�_^kܚt{�^��*�G�#�����Q�q�=��6���N�+�4	��`��f'٣����y���@ `09y��kye��	V�m��~n�=�v	�&'�� �2�vz|�e��s����=�����s��˙H���398��\�����;EQ=�2�}��>���Ej��D�h��t�$à��u���V�+��}o�I
VNu�($�?�H�9�Bڵ*�jA黛�P�*���Mt�>��}ze�M��r������F����8[����F#Ƿ
Ԗ�Ԃ��7�.,�s9�3b"G��N�t�=5́�|���|��T"p-���ĶE��F`	,�Q�	��ܖ�nd�b�<L�_�ʹ>�2Y��4��۱5{�_w��ş��o�WA&H�	�I�^�\�V�@0��kL�`���#tk]��{�<���0�1J���]Z����[���z�'v���.�#;I��D�?�օM�g�6`���
��رW�e�=�}�j�����q�2o1��$'�)�DN>����>���1<�HEz��zܯ���#�����7|HB���Q����^�����D��BwU�}PH$&�F��EqQ/�c��0��,쏔�b6��N���=$?\�w۪��G1��I�n�>S�_�#O�T+J}�����}�oT�À���h������oZq��+$b��b4���u���P,��~����\�W�g KrT*��D>T�wk(�/绁���7:d�D�4(��*�·5�G�OQ�ߑp�
endstream
endobj
33 0 obj
<</Type/FontDescriptor/FontName/EKSDVQ+CMMI8/FontBBox[0 -204 907 704]/Flags 4
/Ascent 704
/CapHeight 704
/Descent -204
/ItalicAngle 0
/StemV 136
/MissingWidth 500
/CharSet(/C/T/i/m/n/phi/x/y)/FontFile3 70 0 R>>
endobj
70 0 obj
<</Filter/FlateDecode
/Subtype/Type1C/Length 1481>>stream
x���{lSU��c;����vQ�-�<�DD��._:A�l�n��E߷��m��~������6֎��u�S��b�E��	h"1��z�X1����N�INN����|�$Q0� I����򙕿�r����3�;���D��̈́b��^�	k�����F��$���B�4�[��Y��%����*/_��\���Q�4H��J)��Ȥl��]�����a�ŏ4��r�}�����R�f�B��ؒ2���mW3F�c�krV\%�1���^_+2��e��JE#��+�[�@�vC�:Ek���M��x�x��"�Ĭ�|Dq�|n������$g8wINd�pt��n>�P�k�Ja �H�� _*�=~��{�&�u5�|a��6��L���b�X��v��nqS�ri#��I�z��]tb�!\'�'&+Vm�0r������j�c��Ʋ	<�������=T���;���Z����J{l�/������\�5�;d�&��*����G��-ʒӗ�}�r�/�C�8Bv��m�Q���^����|'o��x#����[���go���cF}����qv�))O����->����c�G������7�XX��j3m�A0���%���+/&2��|����p�[�=�y�ځ�drb`��wl�aZYJ;�a�OV���}A����G��� �ʐ�Io����v�v���k}�t�@���~8>�2ĵJ9��W�>����A*)9���#O�y�?\��OW�P�&ypg8?I��%χ��'�N���p*�|]&{��u޽�=#��\a0~�A��a����L��imr���v��]��)@���'.�ަ#�}0���:V����o���p$@����;	(�gau6�n���7BZ�ꝣé��%K#����A����c����+#��N�l��L5|p}��Q%����b�%������z�@�������vGGjt���/�&��)g���R����o��+�p}} �9�����#�H�?��Q_*��k{7�#�Ŧ?g�\>��8o�EF�p�@���U���]�M�� }Z�C�u��Q�uҞn�5�������T�03nu�B5x����y�n8������������Q\���p�絹]z���EגV�ݽ J�,���@�L ��ׅxߝԛ��x7(56�趀+yJ}�@�����Yϭ�[����?�eO�N�f{���۩��8��-�]e|ڡ�\+r�2p�#����n���ʹE�C��6�J)󟍱���re;�������u�S�35�j��%����s��a��n��4��I���[�����=*�v��&���EU�~��_��K),:�(��m��ٶ�k�����Н��BC!� ~���w�[��⢅��])���^,��5�"�	#j�
��<��\��,��H��0W�����B�.R4>��9�삇v����	�W�;&�
endstream
endobj
31 0 obj
<</Type/FontDescriptor/FontName/HWRRST+CMMI10/FontBBox[-32 -205 848 716]/Flags 4
/Ascent 716
/CapHeight 716
/Descent -205
/ItalicAngle 0
/StemV 127
/MissingWidth 500
/CharSet(/A/C/b/comma/epsilon1/f/g/greater/i/j/lambda/less/m/n/p/period/phi/q/r/s/u/x/y)/FontFile3 71 0 R>>
endobj
71 0 obj
<</Filter/FlateDecode
/Subtype/Type1C/Length 3059>>stream
x��VkpS癖�ǘ&S�v��(�@�6,I��(q �����$[wY7ۺ�_��e˲囌m�1��\ �ri��L	,N�N;�Y�;�ag�`ض�Mgv����|s�w��y��y^&c���\^T\�k��{�&W1��K��)�­��� �yK�V���Q4���D��1r�Lq����%���ଭY�ٴe�����7n��yUX'��pE�b��W'�*�&N���_��p־�S($/>��J�z�+�?+�5l]����+x��:y�LYW�y],Rp��
�8�>{�R$J�u2N���N&j�
��r%<~�D�o�61��**�He�f�M}_ |y�K/����=���%�R�~F��QĨd�`�d�����&�G������b��(��a,e�0˙�Yb�gM.�����Er~�su������}4��;��?��6��� �&Ȣ�,�=�D;�rv��ڶj��ePcV�-��C�; Ga�1��=�CW��
�<����g��ȗ�Q&��`Ą�U�T�x�p�{�~�#��~RQ#�!8� �\X�L�O�-`�X������*З�ԗ���?��4��b����؎V�l�&aj�u�RA��M2�+�i�/t�ڳ3��T�^P\I}��0aR��`���9��EL�0��Ն�vJ+�Z"=�po8Mt�L�%0����DѦ��
-n;$[U��5jZ�m{��#����� ��(uf�TT'P:�r"�PsvaC�y�6k�����uM��`��o5%�>�XPHɩfJJ�R[P.�D��l�����&o���i�9�N�$R���}����-l������n��Cĥ��y�`�~a+��8\`$�Q�������I�ʲh�"u��YST>��wZ��@m��CD?.�:r_V|Q��
�c�hs0C�E���!=��F�|S2����Za|�pw�"&�������#�0�)�������t��f�I�&zy{�
��:���mA=`�t_<��ƈ|���'>b��"���jjDZ���ڎF��\j%��Z��B��'����&��Z�0��f{��ѥG3'�a�K��G��-o�gz�0Ah5{����3����$����<ؕċ�~J����ݥ���nt�V���������վ����k�~_|`�7
���>h׻Ahk��k��i2z�F����R���S��l>�.�gH��Dk?���΢u�,r���T�Ќ��[������'�Q�k����A+~�x� �1�b3�׶f��-3XOKL)*����@/G+���}�����PM����K73�Zj��Һ��#F/�з���#�ғ0
==�ɱ�%�`��岷9�R�.`Jc�h:6%�����{"��:i�6��o�կUSE�2���� +7N;?�y�U"6�O@6�x�b}=��t�O��|5~l�p��QnY[����b���_��776�N�xeH�o!�=���/�Y�+�>;��3���:�M%��2��Ήs{�}�2��ͽ�d	Ŗ��h��	{��;s���FM���;�)�R��V���g��n����P�P&m�zWujn�Z�����j/��,bg��cr�-NB��!�+��ex����)Z�W	F�����p�����n�����R��2�@����~�c1ZL|��B}���� �p�L�'(�D��S�ˮ�TuD�$�U[ف4x��w�L��6�/���;�j��?邮��4�MOޜ��I-�ۗ 3�X[M��fn�k,R��*9D�,��޾��S�N'?�It��E!�]��31D�JB��(�����5%p{������� �+�W֔I�u�*h�C^���C"	G�²�Q!h��8U�����F�h��h�]7II��ՙf�̣_ͳH��FN*���Z�s�Q��;�Q V�J�w��n�.M��ȃVLѩ��L����9�C�V�[���z{=GM�'M|1���]B�c��r(��ԝ���1h�z41�T�\w�����;���=h�;H;��F��4�D���u�H�`�?�iR�%�;�9�뫡-.��š�Z{i������v)��g���_�8�A�����>Hb�.Is����1���#�s�W�r�U��5���&]���&h���?K��srb��ċ6�����~΢�n1��x���c�ة��D"���ޞ��!|��<vl���?��KKn��G�*-J��0KQX�a�T' %vp�w��5�����p �s�.��h�"_��E@�y$��"�u�%�
�B�J�������T�nf���]RJ�_+h�CA��S���Dʆ���3׾��c�'��S� o�,w�bM��a��+�g.���>`�N;�~f��y�}�[X��<d�YH�)L�ͮ2��Vx��l 3���$|��Ay�	��(���K����n �w*�e�?��?�s��E*Wj&_y�@uY=�;FĽ��F�6A�n��6�:��������p�h�K�,t�v�#)�$b-l&m�X �(5�'Xt�ݳT�`3�@_��-j#酂��^���p4j����4r/�_�!5;��!1���{%
tA'8 3�L�ߚ�d�rߥm�L���)�]'��!�n��&ڕf�j7{Nv�V���%)��X���^�����v����#��c������{���;,��=(���r��W>8��;H;���gS���Bh�}�3ԆEGs�K����z�����[R�ar�@�������`9��QkК��*S@R�z��
�BmB���FB�w�)n7z-E>׍ZS�w����k�y6=E���!�7�Z;��j�~b���
�Z]믽��-�&K��I�XwOР�����^��	�z�h]���A� �>/���F������[4
�wqк8���g��*�	P�?���~��mj�!����,s�S:���NH&��uR/�����/n��IvЋ:z��C=F��j��ӗ�\�2���&��&�IU���}�7GC����4Y�Ƒ0�Cq�˳���s�nN�=�	��1���Տ
endstream
endobj
29 0 obj
<</Type/FontDescriptor/FontName/IFSIWU+CMTI10/FontBBox[-25 -205 852 705]/Flags 4
/Ascent 705
/CapHeight 705
/Descent -205
/ItalicAngle 0
/StemV 127
/MissingWidth 500
/CharSet(/N/a/b/c/d/e/f/ff/g/h/hyphen/i/l/m/n/o/p/q/r/s/t/u/v/w/x/y/z)/FontFile3 72 0 R>>
endobj
72 0 obj
<</Filter/FlateDecode
/Subtype/Type1C/Length 3421>>stream
x��W{TSw�>1��G���6���uY�>�v��m�ֱV�7�VyC$!�$�"!$�	�A�@B$���� �����:�l�Y�s��{;��s�k��љ�;3+$ge�~g�o���f`�gac�=�vnX?�sEt)#�lV�_�B*u���s`!�/{�׋љ���I��c2�"�6��X����'���߰y���?Z�~s���L!'=��'U����*�����9�����WrD"�O֭�H$kS���ٯ�\/�r�df
ř�o�y�������3ѭ������2��{��B�aKy|A��PT$��Jӊ�K2�ffe�p���,��Dl�;��a��#Xv{Kƶaǰ�aǱ��:�Ml��ۅ���b����2l6��Xȸ4+s�g�t��ٚ���Ĥ�%��O����0��.������O|���W�-�F���1U �&�@��h�8��m,K�Zo	ԜSm�����[���O������IG_b�TS��g�J�CZJ+�@�r?�b��t����͆Q��C�c��'J�v�N�l��d��t�>0�jXjL������� �J��V��שC�Qz��^�w��|6"6j��u�����}7^�Q,�9j��_��Z�X�9�AY)?+#+��p1[.��᳀5�ڗR���H�=yp�V�H���9�����,M�F�a�˔ �Zt6��+����#0��yk�\j���jUy�v��VL� l�@PZ���C��R�9<R9z�%|���A��c"���Տ/��8�MPx�I�0e�Q�����+M�f;My5®3�e����3^�1�U�9|�l.h;8Ť�S�����jl"3��c�n#[�i�Uo#[���Z�]��9����4�*��[~B3��yu=dp|`��p�X�w�<���Xa(��ݬ�G7>�а��`"'��G���M����\��ji�.�>{a�3����"������T	ۚ�f�*�U�wׇ�o��^F��9�%qF��Y}�~5ƹ�-ˋ�[�ˈ��q�)j�"~�ɽ���U�(v��W�Ҫ��?����4�_��ء�p�
� Ը�Z�Pr����I�K{1���3������ݥ�ʎ�m~�W��&��u7��I�Z2rKLJ�r�,���Z��}�A�뜍1%tI���%��l���2���[�/���]�c��(>�������kk�Y���C֍��̨#��e��,P�;5I���1oP��b0�)�R>/��'��Z�[�N��-n��ù���9TB��fwa�4~9
�ө/(T�d�������4ʻ8r&n �����ꃞH]�k�t:T��������x4��	5�A���ݗц!fT]�jSFx"�H��i�Z����K�UE�=�nm�����z3ʼ��D8����C�������x�8Z;�����WXZ�Qr\�����a��Ї�O	���oJ��A�c�
[���ZZ/�j��=Y]�1�=�����Ϣ�0�W���}�$�(���6�ɲ�jS����A�X�.�bOU����Q¥~C`1����K�n��c9�u����Q�r������r�ܥ�*w��껆����:A��p�����%x_0)�`�����;���;��@��(/�����,0�����w������+��B�_8L-M�&��l����.��}��B屲,R�f�P�-�%ޒz(�w�^[B�87�G40���%��T!��:�~���LG
~���
�D���쵟!�=���V���K������pe�0��w��=&�<��/�Z^�ѫ�F=��QUF��Up��j�^F"�>iԫ� ���gǯ�l4�B/LB&G�����,an�G}�m�(��5���o��<��]�-�R=#w��~U`����=����	M�X��歧�?.ﴘL&���X\����e�beF���nΥ?��?���&�����RpnN��y���}K�Q�er "553��Ώ�g�:�.3�#�+��h)�9e��C)��q������y,���hTk��k~TQ�aa��H�סA����~pB����O	�5g ��k���L4�zXc����z���t���D��NŠvHCJo�i.�[S�H�l��dvYH{�9�~��ԭ�N�@iI�J&�^�6={���ʫ���4�mU�����`W�	���������ip(A�4�dq�qN
H@f�T��(�$��6{}��	�f��f�t�2����S�҈�1؏6h{_�P����6�����O� 2Ɉ0�NF����',�˕�&��e��WX��<ȥݜ�ʼ��A� ���XM^0�%����5���g��hm��h�9<#��:;�lAc�^MR��o��R�m`kT����$g*#Sr�`�rA�KkR�̆]�J�Vy+�zq�߳��n`;��d�=� ���d���t�L�A2Vޫ�}���:��9�������n"�R����ok$�V/z��J�]��R�!��EcTj�w'*��5��0��*=��i��4��u5(!_�qXY�i�p���H�jd�:y!H�:�7�����N[)���h	15k��)�$4<�՘7��S�Q�����")� �Ty�w��@�C&JrN��;�؍�ڧF�:*��{�hl�v��	��%q_�ߍ�ě���b>��~"JAy p���z��k�|�y��≯o��@��*mU�f�ixDܗ�rAS�Rj65�J�~����,�>��.�.r�NR�4ܽ��fq�p�9F��ϑ��}��$~�z������{�n��)-�p�s��X����W_S�$�<-�[��.S�n2׵�[zq�˼����G�Ş����b���s�R?]E�y�#��/��h��PMkMy���L��c_�f��P+u���5�Ŵ��D�*�VJ濬�U��<��& �ѐv�^+ZUE���.*b%v�X ������LEC9��aܻ�=A|�>��:	����gv��5Dm��=5N��+���
K�KS��~�!���WȽ���_o�C`v�7��� | ��
�<C�����fׅ^�9��֡��\��'�'�:�Ohn$�NB"���OXCi�I���Y�������L��l��
���	*)F�P�uҩ�ut+N>�ہi�xq��@+���}Z&>����v�ZL�NU7��s���-�b�N*�L4�|���N����gI	q�6����Ǵ��U{�^��%<Lc��W���J!o�X��@˹$�Ajw�rB�����]cJ\�+�R$U����:�BP�����蓶�@Kк01�>���1;���[Kv�
�:u�ޣ��I�Jݧ->��	DEܣ����c�"8�q��E��6'*4{1T�snd����ٛ���.İ����j
endstream
endobj
27 0 obj
<</Type/FontDescriptor/FontName/WCHBWX+CMTT10/FontBBox[0 -229 524 694]/Flags 33
/Ascent 694
/CapHeight 622
/Descent -229
/ItalicAngle 0
/StemV 78
/AvgWidth 525
/MaxWidth 525
/MissingWidth 525
/XHeight 442
/CharSet(/C/G/L/M/R/a/asterisk/c/colon/comma/d/e/eight/equal/f/five/g/h/hyphen/i/k/l/n/o/one/p/parenleft/parenright/period/plus/r/s/seven/six/slash/t/two/u/underscore/v/w/x/y/zero)/FontFile3 73 0 R>>
endobj
73 0 obj
<</Filter/FlateDecode
/Subtype/Type1C/Length 3974>>stream
x��X	Xg�����l�T������Z�Zk���Zŵ�"a�a_;d;��RW�V\�5Tkk�]qik�����y��OX�>��͓�I��7�;�}߳d$��%�HdK�=<f9��N�I�̄����'n`%+��������-��T"	��.ۭQ�+T��}�8�Z���鎳��8���*|�CݽU
�o��v\���8N^�P�v/�9S�V;y�D8�)�O��P)��F�*�|w9�U9���u��Ω�ciX��H����=l��2����aKw+#�TEF���Wk|�w���+�ϝ�����O�2u��N�g:ϚMQoSk���w���5��@m�6Q��%�j��ZF9Q˩ԛ�[�Jj�F��ܩ���ʁGq�j$eIYQ�(kʆr�l);ʞ�S3D()s*��8K̬��Ӥ{�O�7�?����������ϙ�L���#��f)��ay�j�U�(�QE֖�˭ӭ�ڼh�ikm��6Ҷ�����v������B5���a��oD�h��Px�m�Rn	����z(Ꮣ��C+�C��C�~%���q9-?���-	{�#�]��}�}3�m>����xDG3��i�� 9o�:�T��`�sb�4���O���~��9�M沮������O�^vsvrwq�EI�� 9l�+��B�p�-��Mz�6���]�2�ѳj30��%nd���<2���n�����x픅;�q��;N�)���{���>;&+��6�W�#J�4����D�n�B,g/^8��م%�L[��u��82����є`Pr�'����_^|�K���7�J|�������.=�!�a�ߏ�G%�a��3��2#��u�TW�5T%�?�*�j^������8bF�)!$�����k��
K�R�!��)=ȅ�U&����,`U9�lenhΛ�p��o����%!��\fLV��X�2�{�:n�~;D�X��Z�?�q��x^~�#����c�����/����+����(5?U��²��b�����Q�kv�קx�#�'a�A�L�8ǀ���F���}�������PP�Ӊ�|붍�,|)��3���F[��P�|VL^b���������)�}J�E��^"��J����-Ͽ�\S�G��� TWr��\1�V%1�0�(E�@�8�.�A��"�oѕP`��[�J�A)��KO�����G{+@�̈��2��%��Yg��>�&�s0�ha3��P�5���/�x�o�}��)1����01h��pX#��Bz�1�'�>G�ko4A��^7Hj��Ra�H�8F��H	�N$xݢ�O;b#�k�QF�T�*��Z����ՈR��LH�
���b�ቌ�D��k���,2�=�	'�h��) YPR�^�����z~`�AWԊ�� ���zh�/��Uv�ap8م��2K���L:wS;��ZS���e9�� ʳ��;z�]D:J0ka��Oe��ZtQ	q�ɹ٩<�>��yi�˰$D[[�X؞�AAffUVI�>(��3��x�I�|/��2m�n�_9yT;t���$�)��T�K������<p��v|9��jI� �èd����钆���x׉o<��p��J�@�=L�H2�ؒ�>C��~�� ��mz��EX� c�gg��W!� A��DY�N��ü�7�u��x���`E����2�{Q��(nI���d�A8`������R�����;d��)zm�j�������8�<�Id8�N� A�ᯋˀ�����i*��c4��|:�1E9ܳ�r͈�R�%lc(��&��Z.-!z�+0���9Ո2�?)|��2��Z}yӵ	�E\�&/�!V?������|��	Fl6Hz:��S�G6�?%4-T�k��9X��K�UB<0����C�4^5̭Az�x!<SV�y�x�$����j�R��ŰJ

J��ż�L��p�oo����T���	{�S	��-����Rq��i��s�뉐�7�d6-�h
�Y�c�L�N������yy\'�����`��2�z������i��=�\�X�1����9��k�*�׳�JhGz�/�yb9m�!֏&"�cNޮ31�I���#7oH	p9��y�-�v�\��.e�K�`���������K1�Ty�����$}�h���j��)k��ľ���n㤡2��tM4eHHp�)j���DS�%t=�z^�o�m�Ç.�su��_I����'Ϟ?v�̇�o۸n��M�,��;�� ���)M1����6g_f���{���7�D�ߐ�5#���-RTz3c�˼健Ѽ�PI�)�!cAQ�,Lt��7!���x>��=���]szs���]=��t*$@jV�AbIRIFdANVI�{Z�nv���c�--U|]Y!\�-`�v���'I_{�
o�	�4��e�8\�ז�4������׵�0����ވ+���*Q���,V����ck�����3��F� ���Ja�{�ɑ�Cy_�4^9�B�!ڕH�O��n3��UGA$x��T��4� ����-�'6ڐ>U�'�vCAJ�ؤ��=S�͇���p���=�Ʋ����az� ]d� &��Ԑ~���G�μ1�:,,22,�:������{&]KQ�f��2_���,چ�^N�
,M�������b��4~���i��7�>50��_=��!���*|�X�O�7{��?�'���a��|?��� g���3���!"�/lXl��dpjeC7UӁڔ �T�4�j���}��kh9Rq���/q{m�ۯ��*8����CӤ*��I�5���h�vn�������_D=��]��`�K���$/�-�aK��o� �,)7]|�����P��U�7w�8U��ǒQċ�?&�h��J~�����K�8��	6�x�dБa�`W�ڠ�����1 9 �2N[M��וC>�u���7Ͼ�:w庥}n�v���U�D]W�:��b��C`[yyQ���8�.VUdeA	cB�#_�ie�P �Ѽ�,"�Ae�@�Y�4�3z��h	�c)>e���<�y����ݴ�}���`����p��5��$V�.Z��Ė/�9�o.Q�ֺ��zoڡ���_w����v��N��B����W�Y�r���"!�Z�v܆vR�!���!�A���`���u��s��_~��M=�z$�����Vhk��y@���B�
�<>&�ْv�J $��:1P��.�M4�@�$B�]EWn`�T��)&��x��9<<�<��SV���LAzUx(�AƐBbybV�����Ŗ]�[U0��?D�?Ƌ,���m���\:#�Q��S㊴�{y�O$�d�X0&���s�KNM�8&5O]ׄ;p�b�����{�h��i��aQ<Z�?x�XC�_U�wCl S����<�P��+��l/A����}�P��@�Gl�f�g~M���)��+��9Bu��@�M\tQ�>-����Z��MH��=̡�U]x�JuH���Vh-l��XWo��_���b��1�����tq����x�@C�B�D�L �e��WE����d��6qs����QXN����&��lJ��l6�}[l�佚tP3q�1�-�~�f�]����B�|���y��Y�}R��t
�Ra��ǐ����Wڠʺ�*2q��A#������'�*�a�T�zb��e0q��Hm\B��_��B���)����/ݗ�={Zpڈ�D���׼���1���p`ͯd4���C�nQ��u7��q���g�z��Id��z_���ȧ�b�<��!:-11��))Z���0FY�^Zy$��1��Bg�P3�*��uz�Ar�:6��\`SR��!�	��2��O�������aI�/~������;O\����x�X�����kL*�ה7��K��JO���[_x�Y�����uR����(��&_fi��F�k¬F���V�(��+��W
endstream
endobj
25 0 obj
<</Type/FontDescriptor/FontName/IWPQEB+CMCSC10/FontBBox[0 0 700 514]/Flags 131104
/Ascent 514
/CapHeight 514
/Descent 0
/ItalicAngle 0
/StemV 104
/MissingWidth 500
/XHeight 514
/CharSet(/m/p)/FontFile3 74 0 R>>
endobj
74 0 obj
<</Filter/FlateDecode
/Subtype/Type1C/Length 493>>stream
x�cd`ab`dd�p�uv64 �U~H3��a�!����3��4�n�n��?���'~���%����XP��_PY���Q�����`hii��`d``����Z�������X����X��(�'g��T*h�d��X�뗗��%�����i�(�g�d(�����(���(�%�*@����sJKR�|�SR���
r����a`a�fd�����`��碑��,a��y�{�C��׿׉����e����/.b;7�5I�{R[��\���#��v�\ٵ�Gy	�G��-����;�g�n�зN��w�n��n��B���~�u/����{����?�����b�c 3s~Ϟ�u���w�A2���	��-���^����\������o��-s[�˺%�B���%PE�3Ш=;z�w���ٵ�l�s��E�?x�{z���I�o��4�[rj��)�S8�J��6�ܴ��Vq]��b1��ùd"��9<� Ɖ�
endstream
endobj
23 0 obj
<</Type/FontDescriptor/FontName/TLDNYO+CMR12/FontBBox[0 -194 702 714]/Flags 131104
/Ascent 714
/CapHeight 714
/Descent -194
/ItalicAngle 0
/StemV 105
/MissingWidth 500
/XHeight 446
/CharSet(/A/D/colon/comma/e/five/nine/one/p/r/seven/three/two/u/zero)/FontFile3 75 0 R>>
endobj
75 0 obj
<</Filter/FlateDecode
/Subtype/Type1C/Length 1816>>stream
x�eT{PT���e��F �����M�"ʫB0N�GC��Dj�WX�baA��%��~���<����DE1����H�hS�XM�ڦ�s�3�h�W�̜9����������H�ۋ IR�����
�W��*/~�p�|�|�|D��}b�	��Q�?!"IeQM�J]�������e�����D��"��bdq�
m~�\)K����r��)������2ٺ�y:�zKh�^��$/,ڤ�澾>D�����RE
m�"G��J���*d��mz6'�
��:�V���Qh�A��N�+6G�l		��$�����+D�N�A,%��JXL�DK�0�M�IRO����m�{��N�>&^&�/���y�߼<h��O�H~�|2S�fn4��&c9V<�>а_��a����6�>�~���=�ܪ���`���E��]r	��+���{@+URN�m����y�v(��|/�h�1����p��r��^�	�9#Bf�쨄Q�S�ڑ�/�Fԓ9Ġ���0�7���NR��+����Y�ӃTfl>���_z`�9�X��X[;F�;����Y�Ƌ�~�z��ݡgu�
ܴ�|%x�����/�/:=�(9�zC����:`�N����Z��Q
ڍW�P���K����27��ij��tF�/�]�2{��D�lH�lL�;(ߵ?h?�<�*���?�	o��S��n��刴���Դ�Y��q���{_�2��NjA"	^�@v��p��~"�]�p���eXOś[�X!������	�=!B����O�ITTf��O���^����"XLA
��ӌT^�.8'<g�0 N!�E졒j�γ������^�v���A�WE| �`zm�x��!�Œȗ�?�G0�E���i4��5�fV��N�<ȍ�Xeu0�(�^�~�F�ƚ/$�P�B�=��!�V+G>q��oDh	?�|d���*�A|��#f{���5lZ�{&�{����f� ]u�,�ʠ��n���H�#������h>ԕc� �0RU�Ź9�,!x�h����b���r�]ک-���DM-p?��E�=^���Ui��=���6�D�wE�j�d���¾`n�w�Œ�W�+i�>z�����P�I��uN~�WA��i8�.� ��C����܇�<���>r���#��W���U���V�(i25����
�FS~H�2&�E��/Z�
Q/����^��8>������/�b�A}��Q>,�x.���#�.�g>ϻ-:.����Vl����>�C�s��%��KףU�u���K�����z�ߙ�w��ms��
�M=s��d���X�vt�6��V�m�q�fW�o�z�E� m��Ggn"J�� n~G�̠�����]�7�3��&�f�ې�<�*�:0�M�C�'c�*��0v�se��\��>|��l�.Ed�g0�pnv��k���0\�96���VH�7!�jg)�J.�[�A��)�����Dhd�a�`�K���x�N�1��O?��rM�����e�z� �\�LX@E��Lh�k����T�?D�$��L��t������5�P4N�����߇B���Ex,t���1��u����������R��FP�I�?;��C�2�Rw�8���x�z&���W�����>r�>��@���!K�j�j;tK�J����,)/��J����C���Si����{�����]��%�}���};�J�/�v�gP����1p��Xq�3D�SAp��D��RS�r[��oR[h?�	H���#��V����"��ќ�ϸ�>>�>��_�
endstream
endobj
21 0 obj
<</Type/FontDescriptor/FontName/VJMNVZ+CMBX12/FontBBox[0 -200 913 695]/Flags 32
/Ascent 695
/CapHeight 686
/Descent -200
/ItalicAngle 0
/StemV 136
/MissingWidth 500
/XHeight 453
/CharSet(/D/H/P/a/b/colon/e/eight/five/four/i/k/l/m/o/one/r/six/t/three/two/u/w/y)/FontFile3 76 0 R>>
endobj
76 0 obj
<</Filter/FlateDecode
/Subtype/Type1C/Length 2489>>stream
x��V{XTe?�a�1ѓ��̘R�"`��)��a$�� ���e.����0�
r�!�(�e@,�4�l�,���<n�>�k�����gC�=���=3g�����~��Д�$��i��om�����
�ia�$a�H��эR����Uۜ���xb&N�mOQ��%e{��R"#v��a�+�===+���y*�h5	�a�X��J�[�U��M�"@�ѧ*�W����V�����,Qi��"^~~�"%R�[�Y��IHք+|t�z�&�V���n���[��K�k~�pMB,EQ�W��RT�T�dt�vً/-_���򧜨 j�<��
��R��vʇr�6P�S~�&����fR��lʞ�N͠�vPVT(�NO����䓮JVK��\�J�����/d�e-�'�Q֞-`��m��m8!�N��if����r��M��p��0q'�擧��.���ў'�M�<h�u�S�*�o�6�Uh����F@ �ˁ����F�Y2Ӹ �sp����ZN9264O)x2�'tƩ��d1N%�r�����0����I��fu�v ����Cv�X����Stjc�����$�T�/�5����RY�i���������"}Ti�%2�<K�d�C��|�d
>���w�����|�2�N���qu-��qJ�#'��PɌ����yl�]����Z����+��>U 㫍�y>j��H���f���� M�ɍ�e�D�K�bD��&X=bf�p2�!���1���14[2���8@���	c7*�1	l/�1�P�%8"l�~)8�Y�������=C|�ۊL湏b7ކ�f>��I͌_6��+�kߡ:�3ӣ�������=`��= &��ے.S�60�17S�9F</�j�%�!�� �,V�La֑��&�!0�e�V�7�5��z�:�>�A��=��M+N=�]�ePGkG��a�/I�:�CaQq�s�	�M��D��W��J��=X{�� 6�<T�S�N5ם�ɮ�[ƛJ�؏;4��0�,%/�$7dSn~�vgW�|(򽲺�P_w����qh`	}�s�H�ޮ6]�����]�e�-�"�L$��n�Ț_<�������9^ۻ�݌v`���N8��[2�?dO�Z~$�;{�Ru�x��龡�9q�<&8$3����i�b�ߒ�𡙮�.K��U>zc|��\qqb�7OL#������Ě!3����q�Ă?�[�n0�7�t(=-�P�crh��k��QT��γ��:mLbrdH���חow��vBiN+4��Zq��D�x��N���|G�\�p�M`��KNĞ(��"\�=RU�r�����7�&�NF�}E�lUБ�V�Zs�l�YDs	����ڍ��$�<�}ʁ=8O����/�p��!�x�x��O0E�G>�,a�CW�\��UN��'��E�B�C\@��'	&�J����puL�F���fj��ɫ�W$N�o��&4�Zq�g���Z�����'/�A4qh���Ҳ���hf�)��! �C)o�����5�dyV*(�߂�_�4�Mh����Y����c��8��9g�6��)��+�Ƃ?���P�cf�@F~ZanaFk)TꝨR�;DN�e	v�`���	]�(�Ή�dt��ᗈճ!�����Un�E��q��x�^V?[u>���H黗>8W��œ���Dlx��p�Y�PK��$xݹ!�Ba���pB����dh�����erX��&����Gn���~����!J�E��ԉj�K��ܙ�&��F�V�����R�H�#P�n4��L~Ǿ����B���
�M�̽r��쁌�҂�ң|yEk� ��e�7�'Sw�^q5R�w���5�i�6*5d���K�����n�}27,8+Z)�$��tmN��=�aN��Z�7�^?y�����CQ�Z�4��t�F4�O�e����3d��"�Tb&:��*P��6���^
�&׸��p9�h�	��ũ}���a�sΰr>o	/|#F�ka�`Ž�֕s��ȵ�������4�q;�'�m{| �%̏�U�| Y�_�	:ɓ����2]�؁��C}թ��Q<�~�C~�i�9�W�L�v��Y���M�8jE���켇$�G`-���Q�M1m����l��.q�i(���(�5 �_��H 	�=��Y�+j?Ǝ����,�'�k�g������@�^3}�gH���T���l���Y�^�_/W����}QY���|�߳h��E�t���[��ZZ�.t�����/��A�����Vo�RN�$%�H�Tǽ��	�!��g���V�+��~�jW��8�����0�Pɾ�g����8�v�6�U��*���oO�w���턿�&��M�_�;���9���_��m�[�gk.4d�	)�;;>�"`��6w�x��G�4�tc�1א�ِ��-Q�����Y[Z.#;��ғy+�Z[�3%��H7�Nɷ���� e}��
endstream
endobj
19 0 obj
<</Type/FontDescriptor/FontName/CJFXQT+CMR10/FontBBox[-40 -250 1009 750]/Flags 4
/Ascent 750
/CapHeight 750
/Descent -250
/ItalicAngle 0
/StemV 151
/MissingWidth 500
/CharSet(/A/B/C/D/E/F/G/H/I/J/L/M/N/O/P/R/S/T/V/W/Y/a/b/bracketleft/bracketright/c/colon/comma/d/dollar/e/eight/emdash/equal/exclam/f/ff/ffi/fi/five/four/g/h/hyphen/i/j/k/l/m/n/nine/o/one/p/parenleft/parenright/percent/period/plus/q/question/quotedblleft/quotedblright/quoteright/r/s/semicolon/seven/six/t/three/two/u/v/w/x/y/z/zero)/FontFile3 77 0 R>>
endobj
77 0 obj
<</Filter/FlateDecode
/Subtype/Type1C/Length 7929>>stream
x��z	TS׺�����Jz*�=��u��V�u�T�EEf���@�/	�<$�0ā*h����Z�U�u����j��M��N o�{�����/��2$��}�7}�U7J ��\;q��_����n�;Bw�}-oK��^B�e�o�G[~Q?T�m�K	��Є��A�!;�}�F��t�8}��1�&L��0��3d��[��J�0O�0����)�}�gX�È�>aaA3Ə��:.0����c�w��8�������(0 �a�����eq�,�����a�!+=<C(�r�0/p����C�.["]�{Y�[Ď��+�<Vy:z���Y���w�.���L����L�1��wgw1{��ѽ�l;n�ĘI�{�P�ʑJ��fPè5Ի�Z�=ʉN��FP멑�j��Mm��Q����Xj��Gm�R�E�j15�ZB-�&S˨)�rj*��ZIM�VQP,�6N���n�=5�HYS�(�Q���N9P=��T/ʟ�M}D�P}�~�-����[����j�a��~�vZ	���������OK�L4�y����{���z�赼�����Kmf���֧��}���v�m�8T|����nc���o�k��]��"�/�85�f`ޠ�����N"���r�$����r�S�M�_�;��!��1T24k��a��6^aӖ &���/�	���
�!m+��<eF4D�B���ۿ�����^��ѥꃚ:0A��Zu��P�9�X�Ug�5�#��5�q<V���C���q~t��K�ሪIi�$�v��Y�|6���k,��`⭛�[����_|uCOY��]d��ܨVݢ��r��}�^"���������s֯�p�?��F�^9�pL~u�E��50���d��_�x��ڏ�23i�Ħm��Ej0�"�t��g��<
ựHE�h2�9�W����˷L�Bɣ�iɥp��?�6~�k��W&���yK��h�Ko��#.ԏ$B�����kX�+Y�o����Y�Q#A�h5�SӸ%6N&��2#?� ������/���
���Fa��_F����?"1���3�\�AGB��Pp��Pőf}#�������ax�7���J]\6c��6�I�����w��OϤVc���� ��5�`5�}�0"\&�K�K�t��K��I٠�4{�1�0g�����`��Mc����2e���o�7ҝ��괗���2�)��F��n����M����6�d{���6��_��$�����}<�B�~D�dCF��{T\"�0�Y�7�C-�Ϩm��)<����q�XP�SZ���� C�����^u���{�숧��x;iw+�`Bc�}S����%Tx���)���b/�x��3��7�>]ۧnՔC�(k�Ǚt�ݴ�k`P�_~D,��	[I�Og��k������U-G�Z����dl�{/�6��Sw H�5���vnw�?ֶ�f���.Duᩛ�D�V��x ��gK�[�9�H��;��Lt.I[\�5fF8zo	Z��=����Q�p���;��0���,^��+�OIi�	�⧕q;�83CF�q���!���K8p�P�h��Ӱ+2P�+��y� �����[MS6��$\;kB5�h��ňF�F!t����	�X��B�yx0ؾ�6���Ӝ]�K��8D4U�7����DeEh,T�+��(
DR���]���v�ͫ����_G�oYԍ��n[T@|���Ӡn�TB#4C����ʜ:	GH����4�B�L�>�Pḽ����Ή���%��Ɏ:�2�M�HG��h�Q��l�ɶy#�7T��� D9 �:��K���Z	Rݣ��*x����T��Yp/F�B̑�mxNf��/��1�|�"�a�?@hkH��M>y��6�S�R� I�lGGARN�Z]R�i4�).9�vX�'p��|��q����j�L�L��N9K�N�-?puK����	YD�<H+��l�]���8Eʞ��g��!�g��ɧ0�B*?���K�c��t(�ĿkQ�������ϳy�F�`� �@����i���R�S��;��Z��T��2/�rZ܌��8!p�R�Z�.l�9�룉x����]��O� {�
��'a7솦��h�Dsn��;C�b'3��:hB��\BJ���X4Ԅ��!"�t��)��[\E�>O��.W^���
YG���q�{΄��,8h} ����l�&�:Wf�(����9�c����8��8�/��wi ��Jlw?\�Z~B�,�-@��௾EQf�6��q�~�Mv"���X�腉G	=���7t���)[ϛ���ʡo;?��I<���NqUV�cl�o��6�I��ksnr���f��<`fge��Mmge
�L.ؼ�d�p�s���L�e�e2=?�$(�c��t��*-:xQM�,L�
�Pئ���zUND@�2%E�.δ�V�Z�G���/o�b.��2��]�oq4�<�����0���c5�y��Y���R�id��6	 +4�}�F��7;m�/���\k���@]�tg���ˎ�_��Z�D�I���W���<y���S�L<t2xZ
���8"�^e����l�1S^��,))K
ࢉ�(�Ne�$��L�����F��\�٧+@G��ڤ說
��qi�����8�n�%璅�v]�чؠ����*rw![��]Z�6��MzZ�Ϩ��9�O��e�ڎ�(d�(�e(8���m����ѴKW���G��fS�+ܚ������d��&D.�M9��!g����ޣas�V`�/r^ꯋ*�,֕�&�lSK*j�搴r���$�->x|�b�b����!����4�<Gr�4�43I�v8=f�N�-;j�}�tMO�b�&`��j!jD����������4���W�vm��u4X�̌#�8zO\�|�,�Y?'�cP�=d�,W��*�a78��:��%�U͎?a�n,�u�j�n����5&u9TA����Q�ڤ<( CUͧ_}=�.S�M�1!!&Ȝ���OjĀT{-�^���*�BS������[bHl�͢/;s����O��Z��_�̈��4m�:�+���	���͂��ё$��h%��)l8�If���2��ڵ����.��<}׃x��֓���b���D��u<סjߚ��!"ٻ�$�. ;����^z��՘Dފ	�$���E��f(��K	��
�Ʉ ��[ԅ��ב଑v�IUE���29�=���BdH�V�<��C	ױAQ��Ǥ�|4�]`��+���\���D�)5� �LyDaX�4�ߥ�����N��&^P��h�L���Aw��i���g�Wy�r;r�c���+�uE{�����7S�/'~���ibЀj�+;{(�ɕ\��e�^��������#:eҡ�/�F��m#���,���ޤ��,c�QM��Ѯ�6�+$|��F�ߺ�ť���635��z۩�/����^��%������t�,Q0�*)���# #��A�dD��n��e�r����%B$���dx��Q����u#�A$����d��d���莨9�\��{�v�)����{�-��L�1|�Oإ4�w�9���G�c?:�n{�z�=���,�8��}�3V3Ho��h�,���t�����(N��U�9[uXo�_sj�)��E���)iP%?�R�b�&�	�*uy�G~U�Щ
T�
�
"����؉":-Y�J��cڟ�eūU��CF��?JW@��P��/���O�_�s��}6݁9=�g�%sa���P��F�5��E6�!�	�YT-2hA�����}��a���`n��Q$z�F�DMr�R���|�M�=��������T],-o�V. 9�����=f�v<�c��b<O�;H@�'�Eh�&#��cG�ߡ|������}4t�����i�%6�Elє���������糈�����C�H*��S"� �	+��*Е�{�lX�����g�����*�_C"�1P�/G������B���%��^���ُ#���H�?������E������8!�d�w�����"(��l���]�mu=�_����9�xVZ��.0J2sK+���ÂT�bB$��a��H��PZ�k<�(�ɥK���CJ%u��Ҋͣ6hU��d�3Qy��%�E����n�[��V
̸E�>r5xwK�b"}���Q���i
w�ڵܙ�?�C6��/-7jc[6Ur*��*���!I�+u�	M��K�{�Z��_H+9#���`���GJ:�h,�t�B!��5���tf�:Fy2��yn�&5��=n@�&[2#��������(�bQ.��k�fk�@�Cd���]:��<�c����n0?`�]<�ß�	��)EWtNG4-����ڝ�����2p?�y���^`nݮL��8$$�$�>�!�[b��ݲ����f]	ɽ{-s'����ګ�������*;��,KN���զj�	M��ڮ6-MIk��N����!�@?iPp�!�Ti�WGj���&Tڞ,������4�
z�۱�-���p�����@�.�Z��Am�LBI*U|�ֿjǁIdN�<����nIrRZ⿌b�O*��&Uz郳�B16ϟ0;��n�	�U�*;]c��e��Pkr28Pk�5�M;/x? >��֏��D|�-�=MGZr�8|�w|��+�[_.�h�L/s_Ƙ�r=˜ah���˓� /�+H��CS���x2�Եs_mgUZPZUUVVEf./���z4�^PgD�P�Q�6�m:ێDXJ\*M-�A����2[�O�1;!v��':�}G��8`��;=���ݑ`,�85� ��
|��T���.Qp���E�7D�!�U{�Qը�;Q^�>�>��	"�#�R"��*�g4z��TU��)x�b��N�IN'�+������-M�9{(� �a�&��8JT�2������$<���a��$3���B��m���XD�Y�q������@l�R}�`�ڶ
��m6����u��95�9=lU�IbITȕr��}�v�5�|˸Uu
���Ed��
�5��|f�e�(���]FD�"�@���O���?�[�ӣ��G��W�{n�˛#�o�1����܎��LX|�`v�9��+�TdF��]�\��%�\�H8�}���ǩR��d��{�-\l9خ��q�)�C��a�����Sy�JK��~��&�z!��6;m�vO���H�C��4;4�=����5OvD��x7� 5_�f4��bVй�n3[Z�J6��N�t���g���VZ��	
�>۾��M,V����nM�,�D�~D+���c?m5���L��h�zN���ۣ}�9����k����|�(/]���R�"Y��%|	�ög}�VIr��%�(	��mz*�SX�h���B/�lfį�C�B=�����[{<ꌖ���dM���,��듴m�Q�J"�1�@bs�%�ݨu�+��Kj�j~�/����gCo��
.
���g��ը�j`4��+i�����x�B�����s�kԃC��O.�t�Rz�Q�Ѷ�!�x��aq;�C߰e4q��u-eM�.�\��b�{�κ~�~$�9X"~�u�Y�	���N<�,����kS�V�����V^����w�����#���{�&�v[as����6��f�H��g�'��?�A�+6�|��gp�ۀ2/��	��D��Y��r3�o@�Ow�,z&H}'⁾X�t9rgs-4|��$�Dji��C�,���=����j�^s �<��ٺ&�888(җkhߪ�Q'�}6h��EL���o�� ��S��t�X�!T~(��� ��m춽)��������W.l���c��g�a��?�
�ǓNM>c�H�K�3�_b$n�bM�T�?_�Y��:�a�&.B�����Ƣ>�*#��a���9�O������6w�����R~�y#�=F����.�ݶ&j�f_w(���Z ��O�XrbǷd��A��.��Ȁ�/&��鲝���s�ﻑȊ��)h*=���Ѱ��G��18
'�Y__ql^-1���E.��RW�6惝�&s�F��W�{��ho��o����
'�ф��H����
��ɽ�-HlB��[�G���z�d��PX�u��=�jaq=9͹%�\�*S�
LEIIE�����rˤ��Q�D����2����w\Z��ygm�eĿ�IT�6�c���R�����@?c�^{P}���+�*]r�o��{�L�	��~kq�~�}�-q�c+ܧ<�1����ne�����s�a��?�y��'�B�8��s���ͯn!�Jyu}��4�Vs�Mf��Μ�������sh��0�
��9��Y-�39	Y�=�IIrn��%A�`!�4�k�(�]�������W3�]9� Y�C��V�g^ǒ��kh1���Uv����ɠ��e'dgkRs29#?�_��f�?��o�;S�o���������,�W�_�?�I"V1�oD�'��
��[lA	�t+i�A��%P �����Ob$��t|�o�#ot�^���h�(�fQ�^F��:[4� E���_̪l���
���=r9�R�T*`���Z����s�\�Di����d��q�2�����fU�O.����V��I'����I,	n��"���Bk �4o?����~y�7I���L\�ū�M�[<�@1+��[��}�-�&=U�A��Ϭ}�ң/�'�_-3>��_�Q<Ұ�l�^�-���렉9�~������v�Ɩ�Q�A,g:~���� {������,�/����<�*�Ŀ5�&�]u�hRXҲpC�z�C֎������))r(K"%?�8�'�<�/�}�m\ǎ�SSҳ~��g��-	ᮅr���c�G�eb-�8��������c�t_��nDGt޺QȏEQ�ӎ�.��jT#ʇ��p���p��c�0��;Q,D�tP��u����AD?�3�%�xl�=��;�0�HF�	.��9���6!Ze�����J��؁���t���޺=a:n�Rьoy\Iii��3���=7a�E�p���@��2sCO�ѽ��j�B��.j�gfs��Z��]���Y"��U�Xh�{�&��?��'i�������1���;"t9��b!�B��i\����~���s�4��wP�!�]a�V�-���~�^��0/xǸ]��g��0'u��g\	7[���C�W_J�7썯������,<�3p.f�(A=�e�.F���v�ٰ��b��1k�]�#����C�AWIm{�-M�r�d ��G��h-g�H܍���2��܇F�s��|g=Q�SO�x�4�u��u4�d�GKi�����/6�{�\u�����^�	�;{��#��[�[�?��h�js�G��$*A��J?;Q�GgL�p��u+%x����?C��/yZT��Y�����\��$%.%�%4U^FV�z�|��?�z�9������:�^��+NI�v{�����v��k��2�Uǜ!�3��W́O��k�]%�[w*BT��Pe$��T����dP�ݮ_<Z�}N�Im�� ��� ]@�X�	O�"�y��9G�W��'��1צ�\��.>�/�י�J��у����a^��>�ծ�)�\@�SZ0c0�S����/���_�Ț~z�鳣���Tt�2�<��!	d@N�x�t�i��������"�����bKJ"lM�ߥ�]�O^�Ʌպ�63w'Z�o����Ћ�d��%�xv��LYmr`�L�p��F'36R?��DxG.m�q�'��j��WwCV�^�t�zS�ɗ��
endstream
endobj
10 0 obj
<</Type/FontDescriptor/FontName/MWUDWX+CMBX10/FontBBox[0 -201 860 697]/Flags 32
/Ascent 697
/CapHeight 697
/Descent -201
/ItalicAngle 0
/StemV 128
/MissingWidth 500
/XHeight 455
/CharSet(/C/H/N/S/colon/e/five/g/i/n/o/one/p/r/seven/t/three/two/v/x/y/zero)/FontFile3 78 0 R>>
endobj
78 0 obj
<</Filter/FlateDecode
/Subtype/Type1C/Length 2656>>stream
x�uVyTSW1��TJ�kP*R7\Z��Պ���V\�B	R@B�T�@�$�[e_e+{�Jq�z����9n۱���~�^����̜3��s��/���﻿���}W�،aD"��j���L��0m��H���a_[���MǴ�X1c_���H���/Y��8����`��%s�zx,u�(*L�'8��7X�
�
���:����$;��@���[6~bb�ਸy1����8'FhTΛ����	a���1���Qaί���j���	S;�Ƅ������O�Y����!,<��%�<,\�0�M�+�1��leܙ f;����x3k�u�bf23�y���80Rf�H�`l�D�h��春cR��Cjck�i�b�K�%�l87�SsMc'��1��8���v >os@	A(q��� #���l�ᢱ:����?m7��a,��R��BNj~wK1���������ʥw�a��t[%+5_΃P��pS�)H�DM8	�p�X��hN���,!�y�E�Ȅ�n�>~��9�.'��GF���3�)kQT|�]u
���@��*��Nn1�H���7R-¯��t���y�dP����g���������5�D�d.q'�$�F܈��:������`?�� S�kf�rXRpI9x�kx_���r�˫��i6��j"5%�5����
�%�K� ���𒢘����p~+�
������?��k_l ��+`]���R���*��6=��#]���{�
t�������4Y��>=�/+��0ň���g�(Jg	��2@�3/����n|,C[�,��롊Qn[fc���鬯/FOVz�z�?��|���B���:�nm�K�^�g�Ƈ�����O�����g�\d��� ��7��[��m�ȸ��a�F��8�Bf�����v̚���Y�_��L;,Xl�N��8]<�1,�!c����!�w3�ԔȐbr���۵�G�Q���������}�8���M:~�B�"�J�`�gĂI���f�ga��h^j�eL0X#���t��g�)GLD����,���<1t[��!=G��%PNePh*��P���|aU��W�e8'����}NV��3i��ƘW�J�X_���}V֒�Sܑ���Hby}$D�H{G��`у�G�?)v�%��oȁ:8�������k C^��)�p�l���.��	����]��0e�p�f��+�JM�p��G�/F3泎𼂰��8��6��hv��\��R@oH7dהB+�W���r���˃��BYUpV�:+�s���R�yCp$���E	��|�.N��Q8�R�n���~��S�&�~C�1����*Y!s����(8����5�C���d�����2��:���r}���C<7�N���:�i�e��*�G�B��������~Z�I��7�s�bW2�L}�6��{^��'A�~}��"a���ut��Ng�6�CwUs}ggq#�X0G����&	l�9�ц�.���P��Q��;JI�|�,[��f���!�ݵ�.R�#���3�:��w�[���*��2���4�r������ښ����:�nyrqp�G4�-˽B*C���31*�ބ�p0{Gg�!ݪ���D%zݽp�x���-r���0b!2��Rۡ
�?���.��TӒh��[�db�����(U������=�RŎC�Q�5�����zх�z�	�)c7�3��Qa�����5YoxKp�JԪ��nk��@=�=C�]O�������By�Ğ�����p���G�i5��8�WW95
\�Z���#��]�?�[W@K���=}]s`U��Ԏ��q�'��t�	����v�z�XA�T�{��/��x��@�Q�ul���y�򾾫;�h��	�^F��
�-@�{VrS{.�4tm{�q�{gq/N��
�(C��'dV��.R)�)lCf���2:��h[��/:��!+U�9�_+��"� ��\\
�P3����cv~����\!��`��
鯫�������ی���ŝ�,�`@چwﾋ��_p�O���ڑS��\�(�|�łYx"+,#-X$� q�I�N���R�"y�I�7%%�Ƣ�{PF�].ٲn6��$o �������\���p�t2�Rp��Bkgz���C1��zT�A�a����GN�l~�5�6��6���a���P�7eOyL'Z��I��,9�Z�0��gr�I,�p�>t+��p���/~t��>�����e��,?��H��V��i-��"<����˰XV���z�H����'%*+%Ga�p��)%
%�kz	��x	��z�3k�N�Ati����Q.�d�eJ�.1m}JF�v%�e�&�t����Q�!��!;�6q!���]����ڦ�����Gf�kۋڀ�߷f�w���
H�=$:%��*k¹h�q�l�p8I�6��;�ߤ�\G)�?�ϲ��n�}�Ί�4�����:���\�����EYykCo�	�3��{�'�3��������#�P�#�ɅP.ܷ)����w*����̑'v��m[�t#�pͭg��i`��O˓�O-6ப�"		�c-�P2^>�fI����<;;�4ؽf��g��C�=
endstream
endobj
17 0 obj
<< /Title()
/Dest/subsection.0.6
/Parent 11 0 R
/Prev 16 0 R
>>
endobj
5 0 obj
<</page.1 [4 0 R /XYZ 70.7262421 758.276 null]
/Doc-Start [4 0 R /XYZ 71.7289886 731.871033 null]
/subsection.0.1 [4 0 R /XYZ 71.7289886 579.41748 null]
/Item.1 [4 0 R /XYZ 71.7289886 427.740814 null]
/Item.2 [4 0 R /XYZ 71.7289886 365.091766 null]
/subsection.0.2 [4 0 R /XYZ 71.7289886 305.785187 null]
/Item.3 [4 0 R /XYZ 71.7289886 208.202606 null]
/page.2 [42 0 R /XYZ 70.7262421 758.276 null]
/Item.4 [42 0 R /XYZ 71.7289886 731.871033 null]
/Item.5 [42 0 R /XYZ 71.7289886 673.684631 null]
/subsection.0.3 [42 0 R /XYZ 71.7289886 499.884338 null]
/Item.6 [42 0 R /XYZ 71.7289886 338.731262 null]
/Item.7 [42 0 R /XYZ 71.7289886 291.042145 null]
/subsection.0.4 [42 0 R /XYZ 71.7289886 158.038147 null]
/page.3 [50 0 R /XYZ 70.7262421 758.276 null]
/Item.8 [50 0 R /XYZ 71.7289886 650.838257 null]
/Item.9 [50 0 R /XYZ 71.7289886 513.046509 null]
/Item.10 [50 0 R /XYZ 71.7289886 463.857727 null]
/Item.11 [50 0 R /XYZ 71.7289886 330.085968 null]
/page.4 [56 0 R /XYZ 70.7262421 758.276 null]
/subsection.0.5 [56 0 R /XYZ 71.7289886 662.013 null]
/Item.12 [56 0 R /XYZ 71.7289886 602.245728 null]
/Item.13 [56 0 R /XYZ 71.7289886 190.144165 null]
/page.5 [61 0 R /XYZ 70.7262421 758.276 null]
/Item.14 [61 0 R /XYZ 71.7289886 471.69 null]
/Item.15 [61 0 R /XYZ 71.7289886 427.469788 null]
/Item.16 [61 0 R /XYZ 71.7289886 396.845367 null]
/subsection.0.6 [61 0 R /XYZ 71.7289886 255.367828 null]>>endobj
88 0 obj
<</Type/Metadata
/Subtype/XML/Length 1527>>stream
<?xpacket begin='﻿' id='W5M0MpCehiHzreSzNTczkc9d'?>
<?adobe-xap-filters esc="CRLF"?>
<x:xmpmeta xmlns:x='adobe:ns:meta/' x:xmptk='XMP toolkit 2.9.1-13, framework 1.6'>
<rdf:RDF xmlns:rdf='http://www.w3.org/1999/02/22-rdf-syntax-ns#' xmlns:iX='http://ns.adobe.com/iX/1.0/'>
<rdf:Description rdf:about='aadbba59-da21-11ed-0000-3ed81fc64b9f' xmlns:pdf='http://ns.adobe.com/pdf/1.3/'><pdf:Producer>dvips + GPL Ghostscript 8.71</pdf:Producer>
<pdf:Keywords>()</pdf:Keywords>
</rdf:Description>
<rdf:Description rdf:about='aadbba59-da21-11ed-0000-3ed81fc64b9f' xmlns:xmp='http://ns.adobe.com/xap/1.0/'><xmp:ModifyDate>2013-04-10T13:36:04-04:00</xmp:ModifyDate>
<xmp:CreateDate>2013-04-10T13:36:04-04:00</xmp:CreateDate>
<xmp:CreatorTool>LaTeX with hyperref package</xmp:CreatorTool></rdf:Description>
<rdf:Description rdf:about='aadbba59-da21-11ed-0000-3ed81fc64b9f' xmlns:xapMM='http://ns.adobe.com/xap/1.0/mm/' xapMM:DocumentID='aadbba59-da21-11ed-0000-3ed81fc64b9f'/>
<rdf:Description rdf:about='aadbba59-da21-11ed-0000-3ed81fc64b9f' xmlns:dc='http://purl.org/dc/elements/1.1/' dc:format='application/pdf'><dc:title><rdf:Alt><rdf:li xml:lang='x-default'>()</rdf:li></rdf:Alt></dc:title><dc:creator><rdf:Seq><rdf:li>()</rdf:li></rdf:Seq></dc:creator><dc:description><rdf:Seq><rdf:li>()</rdf:li></rdf:Seq></dc:description></rdf:Description>
</rdf:RDF>
</x:xmpmeta>
                                                                        
                                                                        
<?xpacket end='w'?>
endstream
endobj
2 0 obj
<</Producer(dvips + GPL Ghostscript 8.71)
/CreationDate(D:20130410133604-04'00')
/ModDate(D:20130410133604-04'00')
/Creator(LaTeX with hyperref package)
/Title()
/Subject()
/Author()
/Keywords()>>endobj
xref
0 89
0000000000 65535 f 
0000037434 00000 n 
0000083799 00000 n 
0000037289 00000 n 
0000036451 00000 n 
0000080777 00000 n 
0000000015 00000 n 
0000006557 00000 n 
0000037576 00000 n 
0000044880 00000 n 
0000077666 00000 n 
0000037376 00000 n 
0000037617 00000 n 
0000037697 00000 n 
0000037790 00000 n 
0000037883 00000 n 
0000037976 00000 n 
0000080697 00000 n 
0000044198 00000 n 
0000069117 00000 n 
0000043852 00000 n 
0000066247 00000 n 
0000043523 00000 n 
0000064060 00000 n 
0000043357 00000 n 
0000063256 00000 n 
0000042953 00000 n 
0000058776 00000 n 
0000042448 00000 n 
0000054998 00000 n 
0000041905 00000 n 
0000051564 00000 n 
0000041156 00000 n 
0000049771 00000 n 
0000040595 00000 n 
0000048445 00000 n 
0000040148 00000 n 
0000047467 00000 n 
0000039693 00000 n 
0000046166 00000 n 
0000038069 00000 n 
0000038099 00000 n 
0000036611 00000 n 
0000006577 00000 n 
0000014116 00000 n 
0000039210 00000 n 
0000045223 00000 n 
0000038250 00000 n 
0000038431 00000 n 
0000038461 00000 n 
0000036788 00000 n 
0000014137 00000 n 
0000022395 00000 n 
0000038590 00000 n 
0000038777 00000 n 
0000038807 00000 n 
0000036965 00000 n 
0000022416 00000 n 
0000029660 00000 n 
0000038936 00000 n 
0000038966 00000 n 
0000037127 00000 n 
0000029681 00000 n 
0000036430 00000 n 
0000039084 00000 n 
0000039114 00000 n 
0000045461 00000 n 
0000046413 00000 n 
0000047761 00000 n 
0000048745 00000 n 
0000049998 00000 n 
0000051854 00000 n 
0000055270 00000 n 
0000059197 00000 n 
0000063483 00000 n 
0000064346 00000 n 
0000066543 00000 n 
0000069652 00000 n 
0000077956 00000 n 
0000039577 00000 n 
0000039894 00000 n 
0000040425 00000 n 
0000040969 00000 n 
0000041498 00000 n 
0000041583 00000 n 
0000042325 00000 n 
0000042869 00000 n 
0000044728 00000 n 
0000082195 00000 n 
trailer
<< /Size 89 /Root 1 0 R /Info 2 0 R
/ID [<F6B306C1FDBAD3A54E688052262991EC><F6B306C1FDBAD3A54E688052262991EC>]
>>
startxref
84010
%%EOF
                                                                        ./lineDrawer.m                                                                                      0000600 0112121 0112333 00000000720 12134070655 013702  0                                                                                                    ustar   silao_xu                        silao_xu                                                                                                                                                                                                               function []=lineDrawer()

x = 1:10;
y = x + randn(1, 10);
y(1) = y(1)*1000;

f1 = @L1Regression;
f2 = @L1MaxRegression;

scatter(x, y, 25, 'b', '*');
lsline

[f,A,b,Aeq,beq,LB,UB] = f1(x,y);
result = linprog(f,A,b,Aeq,beq,LB,UB);
p = result(1);
q = result(2);
hline = refline([p q]);
set(hline, 'Color', 'r');

[f,A,b,Aeq,beq,LB,UB] = f2(x,y);
result = linprog(f,A,b,Aeq,beq,LB,UB);
p = result(1);
q = result(2);
hline = refline([p q]);
set(hline, 'Color', 'g');

                                                ./optimizeCost.m                                                                                    0000600 0112121 0112333 00000003256 12133604510 014276  0                                                                                                    ustar   silao_xu                        silao_xu                                                                                                                                                                                                               function [x, fval, exitflag, output, lambda]=optimizeCost()
    f = [
            3400; 1600; 
            3400; 1600;
            3400; 1600;
            3400; 1600;
            3400; 1600;
            3400; 1600;
        ];

    A = [
            [-200   150     0       0       0       0       0       0       0       0       0       0];
            [0      0       -200    150     0       0       0       0       0       0       0       0];
            [0      0       0       0       -200    150     0       0       0       0       0       0];
            [0      0       0       0       0       0       -200    150     0       0       0       0];
            [0      0       0       0       0       0       0       0       -200    150     0       0];
            [0      0       0       0       0       0       0       0       0       0       -200    150]
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
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  