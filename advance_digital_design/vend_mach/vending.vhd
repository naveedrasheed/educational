----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    09:47:37 12/15/2009 
-- Design Name: 
-- Module Name:    vending - Behavioral 
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

entity vending is
    Port ( clk : in  STD_LOGIC;
           go : in  STD_LOGIC;
           sw : in  STD_LOGIC_VECTOR (7 downto 0);
           cp : in  STD_LOGIC_VECTOR (7 downto 0);
			  pp : in  STD_LOGIC_VECTOR (7 downto 0);
           sum : out  STD_LOGIC_VECTOR (7 downto 0);
           chang : out  STD_LOGIC_VECTOR (7 downto 0);
           disp : out  STD_LOGIC;
           ret : out  STD_LOGIC);
end vending;

architecture Behavioral of vending is

signal swi,s,ch:STD_LOGIC_VECTOR (7 downto 0);

type state is (ini,ps,chk,cmp);
signal nxt_state,cur_state: state;

begin

seq_log:	process(clk)
begin 
	if(clk='1' and clk'event)then
		sum<=s;
		chang<=ch;
		cur_state<=nxt_state;
	end if;
end process;

comb_log:process(cp,cur_state)
begin 
	case cur_state is
		WHEN ini =>
			swi<=(others=>'0');
			s<=(others=>'0');
			ch<=(others=>'0');
			disp<='0';
			ret<='0';
			nxt_state<=ps;
		WHEN ps =>
			if(go = '1')then
				nxt_state<=chk;
				swi<= sw;
			end if;
		WHEN chk =>
			ret<='0';
			if (cp /=  "00000000")then
				if(cp = "00000010" )then
					s<=s+ cp;
					nxt_state<=cmp;
				else
					ret<='1';
					ch<= cp;
				end if;
			end if;
		WHEN cmp =>
			if(s < pp)then
				nxt_state<=chk;
			else
				ch<=s - pp;
				disp<='1';
				ret<='1';
				nxt_state<=ini;
			end if;
		end case;
	end process;

end Behavioral;