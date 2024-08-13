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

entity complex_fsm is
    Port ( m : in  STD_LOGIC;
           clk : in  STD_LOGIC;
           z : out  STD_LOGIC_vector(2 downto 0));
end complex_fsm;

architecture Behavioral of complex_fsm is

type state is (s0,s1,s2,s3,s4,s5,s6,s7);
signal nxt_state,cur_state: state;

begin

seq_log:	process(clk)
begin 
	if(clk='1' and clk'event)then
		cur_state<=nxt_state;
	end if;
end process;

comb_log:process(m,cur_state)
begin 
	case cur_state is
		WHEN s0 =>
			z<="000";
			nxt_state<=s1;
		
		when s1 =>
			z<="001";
			if(m='0')then
				nxt_state<=s2;
			else if(m='1')then
				nxt_state<=s3;
			end if;
			end if;
		when s2 =>
			z<="010";
			if(m='0')then
				nxt_state<=s3;
			else if(m='1')then
				nxt_state<=s6;
			end if;
			end if;
		when s3 =>
			z<="011";
			if(m='0')then
				nxt_state<=s4;
			else if(m='1')then
				nxt_state<=s2;
			end if;
			end if;
		when s4 =>
			z<="100";
			if(m='0')then
				nxt_state<=s5;
			else if(m='1')then
				nxt_state<=s0;
			end if;
			end if;
			
			when s5 =>
			z<="101";
			if(m='0')then
				nxt_state<=s6;
			else if(m='1')then
				nxt_state<=s4;
			end if;
			end if;
			
			when s6 =>
			z<="110";
			nxt_state<=s7;
			
			when s7 =>
			z<="111";
			if(m='0')then
				nxt_state<=s0;
			else if(m='1')then
				nxt_state<=s5;
			end if;
			end if;
		end case;
	end process;

end Behavioral;
