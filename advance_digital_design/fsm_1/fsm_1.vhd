----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    13:25:11 11/16/2002 
-- Design Name: 
-- Module Name:    fsm_1 - Behavioral 
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

entity fsm_1 is
    Port ( rset : in  STD_LOGIC;
           clk : in  STD_LOGIC;
           button : in  STD_LOGIC_VECTOR (1 downto 0);
           lights : out  STD_LOGIC_VECTOR (1 downto 0));
end fsm_1;

architecture Behavioral of fsm_1 is
type statetype is (Idle,opt1,opt2,error);
signal crt_state, nxt_state : statetype;
begin

fsm1: process (button, crt_state)
		begin
			case(crt_state) is 
				when Idle=>
					lights<="00";
						case(button) is
							when "00"=>							nxt_state<=Idle;
							when "01"=>							nxt_state<=opt1;
							when "10"=>							nxt_state<=opt2;
							when others=>							nxt_state<=error;
						end case;
				when opt1=>
					lights<="01";
						if button /="01" then
						 nxt_state<=Idle;
						end if;
				when opt2=>
					lights<="10";
						if button /="10" then
						 nxt_state<=Idle;
						end if;
				when error=>
					lights<="11";
						if button /="00" then
						 nxt_state<=Idle;
						end if;						
			end case;	end process;
fsm2: process(rset,clk)
		begin
			if(rset='0')then
				crt_state<=Idle;
			 else if (clk'event and clk='1')then
				crt_state<=nxt_state;
			end if;
			end if;
		end process;
			

end Behavioral;

