window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.LogicaProgWeb = window.blockly.js.blockly.LogicaProgWeb || {};

/**
 * @function Executar
 *
 *
 *
 * @param entradaUsuario
 *
 * @author Yury Trindade Da Cunha
 * @since 25/03/2025, 11:58:28
 *
 */
window.blockly.js.blockly.LogicaProgWeb.ExecutarArgs = [{ description: 'entradaUsuario', id: '127c79b6' }];
window.blockly.js.blockly.LogicaProgWeb.Executar = async function(entradaUsuario) {
 var respostaServidor;
  //
  this.cronapi.util.callServerBlocklyAsynchronous('blockly.LogicaProg:Executar', async function(sender_respostaServidor) {
      respostaServidor = sender_respostaServidor;
    //
    this.cronapi.notification.customNotify('info', respostaServidor, 'fade', 'top', 'center', 'false');
  }.bind(this), entradaUsuario);
}
