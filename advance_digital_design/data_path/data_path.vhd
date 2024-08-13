----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    20:52:44 12/31/2009 
-- Design Name: 
-- Module Name:    data_path - Behavioral 
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

entity data_path is
    Port ( clk : in  STD_LOGIC;
           rst : in  STD_LOGIC;
           RegDst : in  STD_LOGIC;
           Branch : in  STD_LOGIC;
           MemRead : in  STD_LOGIC;
           MemtoReg : in  STD_LOGIC;
           ALUOp : in  STD_LOGIC_VECTOR (1 downto 0);
           MemWrite : in  STD_LOGIC;
           ALUSrc : in  STD_LOGIC;
           RegWrite : in  STD_LOGIC;
           insAddr : in  STD_LOGIC_VECTOR (7 downto 0);
           inst : in  STD_LOGIC_VECTOR (31 downto 0);
           data_in : in  STD_LOGIC_VECTOR (31 downto 0);
           data_out : out  STD_LOGIC_VECTOR (31 downto 0));
end data_path;

architecture Behavioral of data_path is

begin


end Behavioral;

