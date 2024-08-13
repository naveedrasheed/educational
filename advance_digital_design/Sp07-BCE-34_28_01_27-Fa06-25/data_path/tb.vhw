--------------------------------------------------------------------------------
-- Copyright (c) 1995-2003 Xilinx, Inc.
-- All Right Reserved.
--------------------------------------------------------------------------------
--   ____  ____ 
--  /   /\/   / 
-- /___/  \  /    Vendor: Xilinx 
-- \   \   \/     Version : 8.1i
--  \   \         Application : ISE
--  /   /         Filename : tb.vhw
-- /___/   /\     Timestamp : Wed Jan 13 12:57:26 2010
-- \   \  /  \ 
--  \___\/\___\ 
--
--Command: 
--Design Name: tb
--Device: Xilinx
--

library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;
USE IEEE.STD_LOGIC_TEXTIO.ALL;
USE STD.TEXTIO.ALL;

ENTITY tb IS
END tb;

ARCHITECTURE testbench_arch OF tb IS
    FILE RESULTS: TEXT OPEN WRITE_MODE IS "results.txt";

    COMPONENT data_path
        PORT (
            clk : In std_logic;
            rst : In std_logic;
            pc_src : In std_logic;
            alu_src : In std_logic_vector (1 DownTo 0);
            alu_op : In std_logic_vector (1 DownTo 0);
            mem_rd : In std_logic;
            mem_wt : In std_logic;
            mem2reg : In std_logic;
            reg_wt : In std_logic;
            pce : In std_logic;
            addr : In std_logic_vector (7 DownTo 0);
            data : In std_logic_vector (31 DownTo 0);
            O : Out std_logic_vector (31 DownTo 0)
        );
    END COMPONENT;

    SIGNAL clk : std_logic := '0';
    SIGNAL rst : std_logic := '1';
    SIGNAL pc_src : std_logic := '1';
    SIGNAL alu_src : std_logic_vector (1 DownTo 0) := "00";
    SIGNAL alu_op : std_logic_vector (1 DownTo 0) := "00";
    SIGNAL mem_rd : std_logic := '1';
    SIGNAL mem_wt : std_logic := '1';
    SIGNAL mem2reg : std_logic := '1';
    SIGNAL reg_wt : std_logic := '1';
    SIGNAL pce : std_logic := '1';
    SIGNAL addr : std_logic_vector (7 DownTo 0) := "00000000";
    SIGNAL data : std_logic_vector (31 DownTo 0) := "00000000000000000000000000000000";
    SIGNAL O : std_logic_vector (31 DownTo 0) := "00000000000000000000000000000000";

    SHARED VARIABLE TX_ERROR : INTEGER := 0;
    SHARED VARIABLE TX_OUT : LINE;

    constant PERIOD : time := 200 ns;
    constant DUTY_CYCLE : real := 0.5;
    constant OFFSET : time := 0 ns;

    BEGIN
        UUT : data_path
        PORT MAP (
            clk => clk,
            rst => rst,
            pc_src => pc_src,
            alu_src => alu_src,
            alu_op => alu_op,
            mem_rd => mem_rd,
            mem_wt => mem_wt,
            mem2reg => mem2reg,
            reg_wt => reg_wt,
            pce => pce,
            addr => addr,
            data => data,
            O => O
        );

        PROCESS    -- clock process for clk
        BEGIN
            WAIT for OFFSET;
            CLOCK_LOOP : LOOP
                clk <= '0';
                WAIT FOR (PERIOD - (PERIOD * DUTY_CYCLE));
                clk <= '1';
                WAIT FOR (PERIOD * DUTY_CYCLE);
            END LOOP CLOCK_LOOP;
        END PROCESS;

        PROCESS
            PROCEDURE CHECK_O(
                next_O : std_logic_vector (31 DownTo 0);
                TX_TIME : INTEGER
            ) IS
                VARIABLE TX_STR : String(1 to 4096);
                VARIABLE TX_LOC : LINE;
                BEGIN
                IF (O /= next_O) THEN
                    STD.TEXTIO.write(TX_LOC, string'("Error at time="));
                    STD.TEXTIO.write(TX_LOC, TX_TIME);
                    STD.TEXTIO.write(TX_LOC, string'("ns O="));
                    IEEE.STD_LOGIC_TEXTIO.write(TX_LOC, O);
                    STD.TEXTIO.write(TX_LOC, string'(", Expected = "));
                    IEEE.STD_LOGIC_TEXTIO.write(TX_LOC, next_O);
                    STD.TEXTIO.write(TX_LOC, string'(" "));
                    TX_STR(TX_LOC.all'range) := TX_LOC.all;
                    STD.TEXTIO.writeline(RESULTS, TX_LOC);
                    STD.TEXTIO.Deallocate(TX_LOC);
                    ASSERT (FALSE) REPORT TX_STR SEVERITY ERROR;
                    TX_ERROR := TX_ERROR + 1;
                END IF;
            END;
            BEGIN
                -- -------------  Current Time:  85ns
                WAIT FOR 85 ns;
                rst <= '0';
                alu_src <= "01";
                alu_op <= "01";
                addr <= "01001011";
                data <= "00000000000000000000000000010111";
                -- -------------------------------------
                WAIT FOR 1115 ns;

                IF (TX_ERROR = 0) THEN
                    STD.TEXTIO.write(TX_OUT, string'("No errors or warnings"));
                    STD.TEXTIO.writeline(RESULTS, TX_OUT);
                    ASSERT (FALSE) REPORT
                      "Simulation successful (not a failure).  No problems detected."
                      SEVERITY FAILURE;
                ELSE
                    STD.TEXTIO.write(TX_OUT, TX_ERROR);
                    STD.TEXTIO.write(TX_OUT,
                        string'(" errors found in simulation"));
                    STD.TEXTIO.writeline(RESULTS, TX_OUT);
                    ASSERT (FALSE) REPORT "Errors found during simulation"
                         SEVERITY FAILURE;
                END IF;
            END PROCESS;

    END testbench_arch;

