----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    13:51:07 11/23/2009 
-- Design Name: 
-- Module Name:    seq - Behavioral 
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

entity seq is
    Port ( x : in  STD_LOGIC;
           clk : in  STD_LOGIC;
           z : out  STD_LOGIC);
end seq;

architecture Behavioral of seq is

type state is (s0,s1,s2,s3,s4);
signal nxt_state,cur_state: state;

begin

seq_log:.	process(clk)
begin 
	if(clk='1' and clk'event)then
		cur_state<=nxt_state;
	end if;
end process;

comb_log:process(x,cur_state)
begin 
	case cur_state is
		WHEN s0 =>
			z<='0';
			if(x='0')then
				nxt_state<=s0;
			else if(x='1')then
				nxt_state<=s1;
			end if;
			end if;
		
		when s1 =>
			z<='0';
			if(x='0')then
				nxt_state<=s0;
			else if(x='1')then
				nxt_state<=s2;
			end if;
			end if;
		when s2 =>
			z<='0';
			if(x='0')then
				nxt_state<=s3;
			else if(x='1')then
				nxt_state<=s2;
			end if;
			end if;
		when s3 =>
			z<='0';
			if(x='0')then
				nxt_state<=s0;
			else if(x='1')then
				nxt_state<=s4;
			end if;
			end if;
		when s4 =>
			z<='1';
			if(x='0')then
				nxt_state<=s0;
			else if(x='1')then
				nxt_state<=s2;
			end if;
			end if;
		end case;
	end process;

end Behavioral;

