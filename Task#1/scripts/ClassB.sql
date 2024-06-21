create or replace package ClassB
is

  -- расчет суммы процентов по заданной ставке
  -- если ставка не задана будет использована ставка по умолчани
  procedure do_calc_interest(p_amount varchar2, p_interest out number, p_rate number default ClassA.get_default_rate );

end ClassB;
/
create or replace package body ClassB
is


  procedure do_calc_interest(p_amount varchar2, p_interest out number, p_rate number default ClassA.get_default_rate )
  is
  begin
    --
p_interest := p_amount*p_rate;
    --
dbms_output.put_line('do calc: amount='||p_amount||'; rate='||p_rate||'; interest='||p_interest);
    --
end;

end ClassB;
/
