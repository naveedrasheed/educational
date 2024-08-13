----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    17:12:23 10/02/2009 
-- Design Name: 
-- Module Name:    adder - Behavioral 
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

entity adder is
generic(width:natural:=3);
    Port ( A : in  STD_LOGIC_vector (width-1 downto 0);
           B : in  STD_LOGIC_vector (width-1 downto 0);
           SUM : out  STD_LOGIC_vector (width-1 downto 0);
			  CARRYo : out  STD_LOGIC
           
			  );
end adder;



architecture Behavioral of adder is

component half_adder is
port(
A:in std_logic;
B:in std_logic;
sum: out std_logic;
carry: out std_logic
); 
end component ;
component fulladder is
port(
A:in std_logic;
B:in std_logic;
C: in std_logic;
sum: out std_logic;
carry: out std_logic
); 
end component;

signal c: in std_logic_vector(width-1 downto 0);
begin 

adder: for i in 0 to width - 1 generate
ls_bit: if i=0 generate
ls_cell: half_adder port map(A(0),B(0),sum(0),carry(1));
end generate ls_bit;
middle_bit: if i>0 and i< width-1 generate
middle_cell: fulladder port map(A(i),B(i),C(i),sum(i),C(i+1));
end generate middle_bit;
ms_bit: if i=width-1 generate 
ms_cell: fulladder port map(A(i),B(i),C(i),sum(i),CARRYo);
end generate ms_bit;
end generate adder;



end Behavioral;

