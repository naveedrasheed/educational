----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    12:39:57 03/25/2009 
-- Design Name: 
-- Module Name:    lab5 - Behavioral 
-- Project Name: 
-- Target Devices: 
-- Tool versions: 
-- Description: 
--
-- Dependencies: 
--
-- Revision: 
-- Revision 0.01 - File Created
-- Additional Comments: 
--
----------------------------------------------------------------------------------
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

---- Uncomment the following library declaration if instantiating
---- any Xilinx primitives in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity lab5 is


port(a: in std_logic;
 clock: in std_logic;
 reset: in std_logic; 
 x: out std_logic
 
	);
	  
end lab5;


architecture FSM of lab5 is

type state_type  is (s0,s1,s2,s3,s4);
signal next_state,current_state:state_type;


begin
--state registers
state_reg:process(clock,reset)
  begin
    if(reset='1')then
       current_state<=s0;
	 elsif(clock'event and clock='1')then
	    current_state<=next_state;
  end if;
 
end process;
 
--combinaltional logic
com_logic: process(current_state,a)
begin

case current_state is

--state 0
when s0=>     x<='0';
		if a='0' then
		  next_state<=s0;      elsif a='1' then
		  next_state<=s1;
		end if;

--1st one 
when s1=>     x<='0';
		if a='0' then
		  next_state<=s0;      elsif a='1' then
		  next_state<=s2;
		end if;
--2nd one
when s2=>     x<='0';
		if a='0' then
		  next_state<=s3;      elsif a='1' then
		  next_state<=s1;
		end if;
--1st zero
when s3=>     x<='0';
		if a='0' then
		  next_state<=s0;      elsif a='1' then
		  next_state<=s4;
		end if;		
		
--3rd one
when s4=>     x<='1';
		if a='0' then
		  next_state<=s0;
       elsif a='1' then
		  next_state<=s1;
		end if;

--others =>
x<='0';
next_state<=s0;

end case;

end process;
		


end FSM;

