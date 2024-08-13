----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    12:58:33 10/05/2009 
-- Design Name: 
-- Module Name:    s_reg - Behavioral 
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

entity s_reg is
    Port ( I : in  STD_LOGIC;
           clock : in  STD_LOGIC;
           shift : in  STD_LOGIC;
           Q : out  STD_LOGIC);
end s_reg;

architecture Behavioral of s_reg is
signal S:std_logic_vector(3 downto 0):="1101";
begin
process(I,clock,shift,S)
begin
	if(clock='1' and clock'event)then
		if(shift = '1')then
			S<=I & S(3 downto 1);
		end if;
	end if;
end process;

Q<=S(0);

end Behavioral;

