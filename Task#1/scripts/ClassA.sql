create or replace package ClassA
is

  -- установить значение процентной ставки по умолчанию, для дальнейших расчетов
  procedure set_default_rate(p_rate number);

  -- получить текущее значение процентной ставки по умолчанию
function get_default_rate
  return number;

  -- рассчитать сумму процентов с использование ставки по умочанию
function calc_default_interest(p_amount number)
  return number;

  -- рассчитать сумму процентов с заданной ставкой
  -- если ставка не будет задана, будет использована ставка по умолчанию
  -- если принудительно указать null ставку будет использованная специальная ставка
function calc_special_interest(p_amount number, p_rate in number default get_default_rate)
  return number;

end ClassA;
/
create or replace package body ClassA
is
  gv_default_rate number;


function get_special_rate
  return number
  is
  begin
dbms_output.put_line('special rate requested');
return 0.2;
end;

procedure set_default_rate(p_rate number)
  is
  begin
dbms_output.put_line('change default rate from '||gv_default_rate||' to '||p_rate);
gv_default_rate := p_rate;
end;

function calc_default_interest(p_amount number)
  return number
  is
    v_amt  number := 1000;
  begin
    --
ClassB.do_calc_interest(p_amount, v_amt);
    --
return v_amt;
    --
end calc_default_interest;


function calc_special_interest(p_amount number, p_rate in number default get_default_rate)
  return number
  is
    v_amt  number := 1000;
v_rate number := coalesce(p_rate, get_special_rate);
  begin
    --
ClassB.do_calc_interest(p_amount, v_amt, v_rate);
    --
return v_amt;
    --
end calc_special_interest;


function get_default_rate
  return number
  is
  begin
return gv_default_rate;
end get_default_rate;

procedure init_default_rate
  is
  begin
gv_default_rate := 0.1;
dbms_output.put_line('init default rate to value: '||gv_default_rate);
end init_default_rate;


begin

init_default_rate();

end ClassA;
/
