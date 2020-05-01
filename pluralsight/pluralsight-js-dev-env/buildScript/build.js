/*eslint-disable no-console*/
import webpack from 'webpack'
import config from '../webpack.config.prod'
import chalk from 'chalk'

process.env.NODE_ENV = 'production'

console.log(chalk.blue('Genereting mminified bundle for production. This will take a moment...'))

webpack(config).run((err, stats) => {
  if(err) {
    console.log(chalk.red(err))
    return 1
  }
  const jsonStats = stats.toJson()
  if(jsonStats.hasErros) {
    return jsonStats.errors.map(error => console.log(chalk.red(error)))
  }
  if(jsonStats.hasWarnings) {
    console.log(chalk.yellow('Webpack generated the following warnings: '))
    jsonStats.warnings.map(warning => console.log(chalk.yellow(warning)))   
  }
  return 0
})
