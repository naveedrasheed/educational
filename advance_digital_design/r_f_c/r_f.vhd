----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    13:07:49 12/31/2009 
-- Design Name: 
-- Module Name:    r_f - Behavioral 
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

entity r_f isgeneric(width:natural:=32);
    Port ( clock,reset : in  STD_LOGIC;
           wr_en : in  STD_LOGIC;
           w_add : in  STD_LOGIC_VECTOR (4 downto 0);
           a_add : in  STD_LOGIC_VECTOR (4 downto 0);
           b_add : in  STD_LOGIC_VECTOR (4 downto 0);
           data : in  STD_LOGIC_VECTOR (width-1 downto 0);
			  a : out  STD_LOGIC_VECTOR (width-1 downto 0);
           b : out  STD_LOGIC_VECTOR (width-1 downto 0));
end r_f;

architecture Behavioral of r_f is
component reg is
generic (n:natural);
    Port ( 
				clock : in  STD_LOGIC;				clear : in  STD_LOGIC;				load : in  STD_LOGIC;
				I : in  STD_LOGIC_VECTOR (n-1 downto 0);           
           Q : out  STD_LOGIC_VECTOR (n-1 downto 0));
end component;

begin

rf:for i in 0 to width-1 generate
ls_bit:if i=conv_integer(w_add) generate
reg1:reg generic map(width) port map (clock,reset,wr_en,data,a);
end generate ls_bit;
end generate rf;

end Behavioral;

