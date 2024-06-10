declare
  v_amt number;
begin
  
  dbms_output.put_line('*** TEST1');
  ClassA.set_default_rate(0.5);
  v_amt := ClassA.calc_default_interest(1000);  
  
  dbms_output.put_line(''); 
  
  dbms_output.put_line('*** TEST2');
  ClassA.set_default_rate(0.6);
  v_amt := ClassA.calc_special_interest(1000);  


  dbms_output.put_line(''); 
  
  dbms_output.put_line('*** TEST3');
  v_amt := ClassA.calc_special_interest(1000, 0.3);  

  dbms_output.put_line(''); 
  
  dbms_output.put_line('*** TEST3');
  v_amt := ClassA.calc_special_interest(1000, null);  

 
end; 
/
