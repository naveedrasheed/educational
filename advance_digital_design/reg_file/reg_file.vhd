----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    15:52:14 10/09/2009 
-- Design Name: 
-- Module Name:    reg_file - Behavioral 
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

entity reg_file is
	generic(width:natural:=32);
    Port ( clock : in  STD_LOGIC;
           wb : in  STD_LOGIC_VECTOR (width-1 downto 0);
           wr_en : in  STD_LOGIC;
           w_add : in  STD_LOGIC_VECTOR (1 downto 0);
           a_add : in  STD_LOGIC_VECTOR (1 downto 0);
           b_add : in  STD_LOGIC_VECTOR (1 downto 0);
           a : out  STD_LOGIC_VECTOR (width-1 downto 0);
           b : out  STD_LOGIC_VECTOR (width-1 downto 0));
end reg_file;

architecture Behavioral of reg_file is

signal reg0,reg1,reg2,reg3:STD_LOGIC_VECTOR (width-1 downto 0);

begin

write_process:process(clock,wr_en,w_add)
begin
	if(clock='1' and clock'event) then	
		if(wr_en='1')then
		case(w_add) is
		when "00"=>
			reg0<=wb;
		when "01"=>
			reg1<=wb;
		when "10"=>
			reg2<=wb;
		when "11"=>
			reg3<=wb;
		when others =>
		 
		end case;
		end if;
	end if;
end process;read_process:process(a_add,b_add,wr_en)
begin
if(wr_en='0')then
	case(a_add) is
		when "00"=>
			a<=reg0;
		when "01"=>
			a<=reg1;
		when "10"=>
			a<=reg2;
		when "11"=>
			a<=reg3;
		when others =>
		end case;
		
		case(b_add) is
		when "00"=>
			b<=reg0;
		when "01"=>
			b<=reg1;
		when "10"=>
			b<=reg2;
		when "11"=>
			b<=reg3;
		when others =>
		end case;
	end if;
end process;
	
end Behavioral;