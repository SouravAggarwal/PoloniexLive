
package polosoft.sourav.poloniex.poloniexlive.Home;

import java.util.ArrayList;
import java.util.List;


public class GetCoinName {


    public static List<String> getCoinName(String coin) {
        List<String> x = new ArrayList<>();

        if (coin.contains("_")) {
            String[] CoinName = coin.split("_", 2);  //CoinName[0]+"car"+CoinName[1]


            switch (CoinName[1]) {


                case "EXP":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/expanse.png");
                    x.add("Expanse");
                    return x;
                case "XBC":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/bitcoin-plus.png");
                    x.add("Bitcoin Plus");
                    return x;
                case "OPAL":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/opal.png");
                    x.add("Opal");
                    return x;
                case "AEON":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/aeon.png");
                    x.add("Aeon");
                    return x;
                case "DCR":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/decred.png");
                    x.add("Decred");
                    return x;
                case "RIC":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/riecoin.png");
                    x.add("Riecoin");
                    return x;
                case "XPM":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/primecoin.png");
                    x.add("Primecoin");
                    return x;
                case "PASC":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/pascal-coin.png");
                    x.add("Pascal Coin");
                    return x;
                case "BTCS":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/bitcoin-scrypt.png");
                    x.add("Bitcoin Scrypt");
                    return x;
                case "IXC":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/ixcoin.png");
                    x.add("Ixcoin");
                    return x;
                case "NOBL":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/noblecoin.png");
                    x.add("NobleCoin");
                    return x;
                case "DASH":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/dash.png");
                    x.add("Dash");
                    return x;
                case "BTCD":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/bitcoindark.png");
                    x.add("BitcoinDark");
                    return x;
                case "BURST":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/burst.png");
                    x.add("Burst");
                    return x;
                case "SYS":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/syscoin.png");
                    x.add("SysCoin");
                    return x;
                case "MZC":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/mazacoin.png");
                    x.add("MazaCoin");
                    return x;
                case "NAV":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/nav-coin.png");
                    x.add("NAV Coin");
                    return x;
                case "Q2C":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/qubitcoin.png");
                    x.add("QubitCoin");
                    return x;
                case "BELA":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/belacoin.png");
                    x.add("BelaCoin");
                    return x;
                case "NXT":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/nxt.png");
                    x.add("Nxt");
                    return x;
                case "HUC":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/huntercoin.png");
                    x.add("HunterCoin");
                    return x;
                case "XDN":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/digitalnote.png");
                    x.add("DigitalNote");
                    return x;
                case "LSK":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/lisk.png");
                    x.add("Lisk");
                    return x;
                case "GEO":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/geocoin.png");
                    x.add("GeoCoin");
                    return x;
                case "GRS":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/groestlcoin.png");
                    x.add("Groestlcoin");
                    return x;
                case "BLU":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/bluecoin.png");
                    x.add("BlueCoin");
                    return x;
                case "EFL":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/e-gulden.png");
                    x.add("e-Gulden");
                    return x;
                case "GRC":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/gridcoin.png");
                    x.add("GridCoin");
                    return x;
                case "DSH":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/dashcoin.png");
                    x.add("Dashcoin");
                    return x;
                case "XRP":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/ripple.png");
                    x.add("Ripple");
                    return x;
                case "RADS":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/radium.png");
                    x.add("Radium");
                    return x;
                case "EMC2":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/einsteinium.png");
                    x.add("Einsteinium");
                    return x;
                case "BCN":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/bytecoin-bcn.png");
                    x.add("Bytecoin");
                    return x;
                case "STRAT":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/stratis.png");
                    x.add("Stratis");
                    return x;
                case "BLK":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/blackcoin.png");
                    x.add("BlackCoin");
                    return x;
                case "CRYPT":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/cryptcoin.png");
                    x.add("CryptCoin");
                    return x;
                case "BCC":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/bitconnect.png");
                    x.add("BitConnect");
                    return x;
                case "ETC":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/ethereum-classic.png");
                    x.add("Ethereum Classic");
                    return x;
                case "BCY":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/bitcrystals.png");
                    x.add("Bitcrystals");
                    return x;
                case "ETH":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/ethereum.png");
                    x.add("Ethereum");
                    return x;
                case "SMC":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/smartcoin.png");
                    x.add("SmartCoin");
                    return x;
                case "CON":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/paycon.png");
                    x.add("PayCon");
                    return x;
                case "CLAM":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/clams.png");
                    x.add("Clams");
                    return x;
                case "FCT":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/factom.png");
                    x.add("Factom");
                    return x;
                case "UIS":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/unitus.png");
                    x.add("Unitus");
                    return x;
                case "VRC":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/vericoin.png");
                    x.add("VeriCoin");
                    return x;
                case "QORA":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/qora.png");
                    x.add("Qora");
                    return x;
                case "C2":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/coin2-1.png");
                    x.add("Coin2.1");
                    return x;
                case "FCN":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/fantomcoin.png");
                    x.add("Fantomcoin");
                    return x;
                case "DIME":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/dimecoin.png");
                    x.add("Dimecoin");
                    return x;
                case "CC":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/cybercoin.png");
                    x.add("CyberCoin");
                    return x;
                case "LTC":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/litecoin.png");
                    x.add("Litecoin");
                    return x;
                case "AUR":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/auroracoin.png");
                    x.add("Auroracoin");
                    return x;
                case "XMR":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/monero.png");
                    x.add("Monero");
                    return x;
                case "NMC":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/namecoin.png");
                    x.add("Namecoin");
                    return x;
                case "SBD":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/steem-dollars.png");
                    x.add("Steem Dollars");
                    return x;
                case "SC":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/siacoin.png");
                    x.add("Siacoin");
                    return x;
                case "OMNI":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/omni.png");
                    x.add("Omni");
                    return x;
                case "TOR":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/torcoin-tor.png");
                    x.add("Torcoin");
                    return x;
                case "HYP":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/hyperstake.png");
                    x.add("HyperStake");
                    return x;
                case "PPC":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/peercoin.png");
                    x.add("Peercoin");
                    return x;
                case "GAP":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/gapcoin.png");
                    x.add("Gapcoin");
                    return x;
                case "NSR":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/nushares.png");
                    x.add("NuShares");
                    return x;
                case "UTC":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/ultracoin.png");
                    x.add("UltraCoin");
                    return x;
                case "NEOS":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/neoscoin.png");
                    x.add("NeosCoin");
                    return x;
                case "ABY":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/applebyte.png");
                    x.add("ArtByte");
                    return x;
                case "XVC":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/vcash.png");
                    x.add("Vcash");
                    return x;
                case "CACH":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/cachecoin.png");
                    x.add("CacheCoin");
                    return x;
                case "PINK":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/pinkcoin.png");
                    x.add("PinkCoin");
                    return x;
                case "EBT":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/ebittree-coin.png");
                    x.add("Ebittree Coin");
                    return x;
                case "SDC":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/shadowcash.png");
                    x.add("ShadowCash");
                    return x;
                case "TRUST":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/trustplus.png");
                    x.add("TrustPlus");
                    return x;
                case "POT":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/potcoin.png");
                    x.add("PotCoin");
                    return x;
                case "PIGGY":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/piggycoin.png");
                    x.add("Piggycoin");
                    return x;
                case "WDC":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/worldcoin.png");
                    x.add("WorldCoin");
                    return x;
                case "CCN":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/cannacoin.png");
                    x.add("Cannacoin");
                    return x;
                case "DRM":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/dreamcoin.png");
                    x.add("Dreamcoin");
                    return x;
                case "SXC":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/sexcoin.png");
                    x.add("Sexcoin");
                    return x;
                case "PRC":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/prcoin.png");
                    x.add("PRCoin");
                    return x;
                case "LBC":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/library-credit.png");
                    x.add("LBRY Credits");
                    return x;
                case "IOC":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/iocoin.png");
                    x.add("I/O Coin");
                    return x;
                case "URO":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/uro.png");
                    x.add("Uro");
                    return x;
                case "BOST":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/boostcoin.png");
                    x.add("BoostCoin");
                    return x;
                case "MRC":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/microcoin.png");
                    x.add("microCoin");
                    return x;
                case "VIA":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/viacoin.png");
                    x.add("Viacoin");
                    return x;
                case "MAX":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/maxcoin.png");
                    x.add("MaxCoin");
                    return x;
                case "XST":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/stealthcoin.png");
                    x.add("Stealthcoin");
                    return x;
                case "FLT":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/fluttercoin.png");
                    x.add("FlutterCoin");
                    return x;
                case "FLO":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/florincoin.png");
                    x.add("FlorinCoin");
                    return x;
                case "IFC":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/infinitecoin.png");
                    x.add("Infinitecoin");
                    return x;
                case "BLOCK":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/blocknet.png");
                    x.add("Blocknet");
                    return x;
                case "ECC":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/eccoin.png");
                    x.add("E-Currency Coin");
                    return x;
                case "BTS":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/bitshares.png");
                    x.add("BitShares");
                    return x;
                case "DOGE":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/dogecoin.png");
                    x.add("Dogecoin");
                    return x;
                case "XCN":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/cryptonite.png");
                    x.add("Cryptonite");
                    return x;
                case "XCP":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/counterparty.png");
                    x.add("Counterparty");
                    return x;
                case "BTC":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/bitcoin.png");
                    x.add("Bitcoin");
                    return x;
                case "BTM":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/bitmark.png");
                    x.add("Bitmark");
                    return x;
                case "VOX":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/voxels.png");
                    x.add("Voxels");
                    return x;
                case "STEEM":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/steem.png");
                    x.add("Steem");
                    return x;
                case "GAME":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/gamecredits.png");
                    x.add("GameCredits");
                    return x;
                case "CURE":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/curecoin.png");
                    x.add("Curecoin");
                    return x;
                case "DGB":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/digibyte.png");
                    x.add("DigiByte");
                    return x;
                case "QTL":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/quatloo.png");
                    x.add("Quatloo");
                    return x;
                case "BITS":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/bitstar.png");
                    x.add("Bitstar");
                    return x;
                case "VTC":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/vertcoin.png");
                    x.add("Vertcoin");
                    return x;
                case "CORG":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/corgicoin.png");
                    x.add("CorgiCoin");
                    return x;
                case "GML":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/gameleaguecoin.png");
                    x.add("GameLeagueCoin");
                    return x;
                case "FRK":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/franko.png");
                    x.add("Franko");
                    return x;
                case "XC":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/xcurrency.png");
                    x.add("XCurrency");
                    return x;
                case "RDD":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/reddcoin.png");
                    x.add("ReddCoin");
                    return x;
                case "MINT":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/mintcoin.png");
                    x.add("Mintcoin");
                    return x;
                case "ZEC":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/zcash.png");
                    x.add("Zcash");
                    return x;
                case "MEC":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/megacoin.png");
                    x.add("Megacoin");
                    return x;
                case "HIRO":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/hirocoin.png");
                    x.add("Hirocoin");
                    return x;
                case "XEM":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/nem.png");
                    x.add("NEM");
                    return x;
                case "NAUT":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/nautiluscoin.png");
                    x.add("NautilusCoin");
                    return x;
                case "1CR":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/1credit.png");
                    x.add("1CRedit");
                    return x;
                case "QCN":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/quazarcoin.png");
                    x.add("QuazarCoin");
                    return x;
                case "EAC":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/earthcoin.png");
                    x.add("EarthCoin");
                    return x;
                case "CYC":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/cycling-coin.png");
                    x.add("Cycling Coin");
                    return x;
                case "AC":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/asiacoin.png");
                    x.add("AsiaCoin");
                    return x;
                case "XMG":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/magi.png");
                    x.add("Magi");
                    return x;
                case "RBY":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/rubycoin.png");
                    x.add("Rubycoin");
                    return x;
                case "SLR":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/solarcoin.png");
                    x.add("SolarCoin");
                    return x;
                case "NOTE":
                    x.add("https://files.coinmarketcap.com/static/img/coins/16x16/dnotes.png");
                    x.add("DNotes");
                    return x;
            }

        }

    return null;}
}

