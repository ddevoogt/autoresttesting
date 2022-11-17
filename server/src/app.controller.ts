import { Controller, Get } from '@nestjs/common';
import { AppService } from './app.service';

@Controller()
export class AppController {
  constructor(private readonly appService: AppService) { }

  @Get("/health/ready/enum")
  getHealth1(): string {
    return this.appService.getHealth();
  }
  @Get("/health/ready/string")
  getHealth2(): string {
    return this.appService.getHealth();
  }
}
