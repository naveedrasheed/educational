----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    20:46:41 12/23/2009 
-- Design Name: 
-- Module Name:    reg_f - Behavioral 
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

entity reg_f is
	generic(width:natural:=32);
    Port ( clock,reset : in  STD_LOGIC;
           data : in  STD_LOGIC_VECTOR (width-1 downto 0);
           wr_en : in  STD_LOGIC;
           w_add : in  STD_LOGIC_VECTOR (4 downto 0);
           a_add : in  STD_LOGIC_VECTOR (4 downto 0);
           b_add : in  STD_LOGIC_VECTOR (4 downto 0);
           a : out  STD_LOGIC_VECTOR (width-1 downto 0);
           b : out  STD_LOGIC_VECTOR (width-1 downto 0));
end reg_f;

architecture Behavioral of reg_f is

type reg is array (0 to width-1) of STD_LOGIC_VECTOR (width-1 downto 0);
signal reg_no: reg;

begin

write_process:process(clock,reset,wr_en,w_add)
begin
	if(reset = '1')then
		for i in 0 to width-1 loop
			reg_no(i)<=(others => '0');
		end loop;
	else if(clock='1' and clock'event) then	
		if(wr_en='1')then
			reg_no(conv_integer(w_add))<=data;
		end if;
		end if;
	end if;
end process;
read_process:process(a_add,b_add,wr_en)
begin
	if(wr_en='0')then
		a<=reg_no(conv_integer(a_add));
		b<=reg_no(conv_integer(b_add));
	end if;
end process;
end Behavioral;

