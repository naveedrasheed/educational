----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    17:12:57 10/02/2009 
-- Design Name: 
-- Module Name:    g_adder - Behavioral 
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

entity g_adder is
generic(width:natural:=4);

    Port ( 
	 a : in  STD_LOGIC_VECTOR (width-1 downto 0);
           b : in  STD_LOGIC_VECTOR (width-1 downto 0);
			  cin : in  STD_LOGIC;
           sum : out  STD_LOGIC_VECTOR (width-1 downto 0);
           carry : out  STD_LOGIC);
end g_adder;

architecture Behavioral of g_adder is
component full_adder is
port( 
			  a : in  STD_LOGIC;
           b : in  STD_LOGIC;
           cin : in  STD_LOGIC;
           sum : out  STD_LOGIC;
           cout : out  STD_LOGIC);
end component;
signal c_in: STD_LOGIC_VECTOR(width-1 downto 0);

begin
--
g_adder:for i in 0 to width-1 generate
ls_bit:if i=0 generate
ls_cell:full_adder port map (a(0),b(0),cin,sum(0),c_in(1));
end generate ls_bit;
middle_bit: if i>0 and i< width-1 generate
middle_cell:full_adder port map (a(i),b(i),c_in(i),sum(i),c_in(i+1));
end generate middle_bit;
ms_bit: if i= width-1 generate
ms_cell:full_adder port map (a(i),b(i),c_in(i),sum(i),carry);
end generate ms_bit;
end generate g_adder;

end Behavioral;