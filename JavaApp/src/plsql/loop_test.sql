--loop_test.sql

--<반복문>
--1. LOOP
	--문제) 1부터 10까지 출력하시오.
	
declare
	
	i number;
	j number;
	k number;
	
begin
	
	DBMS_OUTPUT.PUT_LINE('--------loop-------');
	
	i := 0;
	
	loop
		
		i := i + 1;
	DBMS_OUTPUT.PUT_LINE(i);
	
	
	exit when i = 10;
	
end loop;
	i := 0;

	DBMS_OUTPUT.PUT_LINE('-------3,6,9------');
	j := 0;
	loop
		j := j + 3;
		DBMS_OUTPUT.PUT_LINE(j);
	 
	 exit when j = 9;
	 
 end loop;
 	j := 0;
	
 --///////////////////////////////////////////////////////////////loop end
 
 --2. for loop
 	--형식)
		--for 변수 IN 최소값 ... 최대값
		--loop
			--반복실행문
		--end loop;
		
	--문제) 화면에 '나는 sql이 좋아요!!'를 10번 출력하시오.
		
	DBMS_OUTPUT.PUT_LINE('-----for loop------');	
	
	for k IN 1..10
	loop
		 DBMS_OUTPUT.PUT_LINE('I like sql!! : ' || k);	
	end loop;
	
	DBMS_OUTPUT.PUT_LINE('-----for loop REVERSE------');	
	
	for k IN REVERSE 1..10
	loop
		 DBMS_OUTPUT.PUT_LINE('I like sql!! : ' || k);	
	end loop;
	
----------------------------------------------------------구구단--

	DBMS_OUTPUT.PUT_LINE('-----for loop 구구단------');	
	
	for k IN 3..5
	loop
		
		DBMS_OUTPUT.PUT_LINE('<' ||k||'단>');	
		for s In 1..9
		loop
			
		 DBMS_OUTPUT.PUT_LINE(k|| 'x' || s || '=' || k*s);	
		 
		 --구구단 결과를 gugudan 테이블에 저장!
		 insert into gugudan values (k, s, k*s);
		 
	 end loop;
	 DBMS_OUTPUT.PUT_LINE('-');
	end loop;
		
--////////////////////////////////////////////////////////////for loop end

 --3. while loop
 	--형식)
		--for 변수 IN 최소값 ... 최대값
		--loop
			--반복실행문
		--end loop;
		
	--문제) 화면에 '나는 sql이 좋아요!!'를 10번 출력하시오.
 
end;
/